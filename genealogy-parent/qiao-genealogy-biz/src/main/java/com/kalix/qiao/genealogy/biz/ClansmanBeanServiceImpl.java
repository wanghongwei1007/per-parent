package com.kalix.qiao.genealogy.biz;

import com.kalix.framework.core.impl.biz.GenericBizServiceImpl;
import com.kalix.framework.core.util.SerializeUtil;
import com.kalix.qiao.genealogy.api.biz.IClansmanBeanService;
import com.kalix.qiao.genealogy.api.dao.IClansmanBeanDao;
import com.kalix.qiao.genealogy.api.dto.ClansmanDTO;
import com.kalix.qiao.genealogy.entities.ClansmanBean;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by wangpeng on 2018/6/15.
 */
public class ClansmanBeanServiceImpl extends GenericBizServiceImpl<IClansmanBeanDao, ClansmanBean> implements IClansmanBeanService {

    @Override
    public void deleteByGenealogyId(long id) {
        dao.deleteByGenealogyId(id);
    }

    @Override
    public ClansmanDTO getClansmanByGenealogyId(int genealogyId, String jsonStr) {
        Map<String, Object> jsonMap = SerializeUtil.jsonToMap(jsonStr);
        String name = (String)jsonMap.get("%name%");
        ClansmanDTO root = new ClansmanDTO();
        root.setId(-1L);
        List<ClansmanBean> beans = new ArrayList<>();
        String sql = "select c from ClansmanBean c where 1=1";
        if (name != null && !name.isEmpty())  {
            sql += " and c.name like '%"+name+"%'";
        }
        if(genealogyId != -1){
            sql += " and c.genealogynameid =" + genealogyId;
        }
        sql += " order by c.id";
        beans = dao.find(sql);

        if(beans != null && beans.size() > 0){
            List<ClansmanBean> rootElements = getRootElements(beans);
            if(rootElements != null && rootElements.size() > 0){
                for(ClansmanBean rootElement:rootElements){
                    Mapper mapper = new DozerBeanMapper();
                    ClansmanDTO clansmanDTO = mapper.map(rootElement,ClansmanDTO.class);
                    getChilden(clansmanDTO, beans, mapper);
                    root.getChildren().add(clansmanDTO);
                }
            }
        }
        return root;
    }

    /**
     * 递归函数加载子节点
     * @param root
     * @param elements
     */
    private void getChilden(ClansmanDTO root, List<ClansmanBean> elements, Mapper mapper){
        List<ClansmanDTO> children = new ArrayList<>();
        for(ClansmanBean clansmanBean : elements){
            if(root.getId() != -1 && (root.getId() == clansmanBean.getFatherid())){
                ClansmanDTO clansmanDTO = mapper.map(clansmanBean, ClansmanDTO.class);
                children.add(clansmanDTO);
                if(clansmanBean.getFatherid() != 0){
                    getChilden(clansmanDTO, elements ,mapper);
                }
            }
        }
        root.setChildren(children);
    }

    /**
     * 获得所有根节点
     * @param elements
     * @return
     */

    private List<ClansmanBean> getRootElements(List<ClansmanBean> elements) {
        List<ClansmanBean> roots=new ArrayList<>();
        for (ClansmanBean element : elements) {
            if (element.getFatherid() == -1) {
                roots.add(element);
            }
        }
        return roots;
    }
}
