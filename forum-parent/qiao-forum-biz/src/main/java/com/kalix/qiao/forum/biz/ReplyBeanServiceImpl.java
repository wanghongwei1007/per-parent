package com.kalix.qiao.forum.biz;

import com.kalix.framework.core.impl.biz.GenericBizServiceImpl;
import com.kalix.framework.core.util.SerializeUtil;
import com.kalix.qiao.forum.api.biz.IReplyBeanService;
import com.kalix.qiao.forum.api.dao.IReplyBeanDao;
import com.kalix.qiao.forum.api.dto.ReplyTreeDTO;
import com.kalix.qiao.forum.entities.ReplyBean;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by sunli on 2018/5/23.
 */
public class ReplyBeanServiceImpl extends GenericBizServiceImpl<IReplyBeanDao, ReplyBean> implements IReplyBeanService {

    /**
     * 回复树
     */
    @Override
    public ReplyTreeDTO getReplyByPostId(long postId, String jsonStr) {
        Map<String, Object> jsonMap = SerializeUtil.jsonToMap(jsonStr);
        String username = (String)jsonMap.get("%username%");
        ReplyTreeDTO root = new ReplyTreeDTO();
        root.setId(-1L);
        List<ReplyBean> beans = new ArrayList<>();
        String sql = "select r from ReplyBean r where 1=1";
        if (username != null && !username.isEmpty())  {
            sql += " and r.username like '%"+username+"%'";
        }
        if(postId != -1){
            sql += " and r.postId =" + postId;
        }
        sql += " order by r.creationDate desc";
        beans = dao.find(sql);

        if(beans != null && beans.size() > 0){
            List<ReplyBean> rootElements = getRootElements(beans);
            if(rootElements != null && rootElements.size() > 0){
                for(ReplyBean rootElement:rootElements){
                    Mapper mapper = new DozerBeanMapper();
                    ReplyTreeDTO replyTreeDTO = mapper.map(rootElement,ReplyTreeDTO.class);
                    replyTreeDTO.setLeaf(rootElement.getIsLeaf() == 0 ? false : true);
                    replyTreeDTO.setParentName("根留言");
                    getChilden(replyTreeDTO, beans, mapper);
                    root.getChildren().add(replyTreeDTO);
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
    private void getChilden(ReplyTreeDTO root, List<ReplyBean> elements, Mapper mapper){
        List<ReplyTreeDTO> children = new ArrayList<ReplyTreeDTO>();
        for(ReplyBean replyBean : elements){
           if(root.getId() != -1 && (root.getId() == replyBean.getParentId())){
                ReplyTreeDTO replyTreeDTO = mapper.map(replyBean, ReplyTreeDTO.class);
                replyTreeDTO.setLeaf(replyBean.getIsLeaf() == 0 ? false : true);
                replyTreeDTO.setParentName(root.getUsername());
                children.add(replyTreeDTO);
                if(replyBean.getIsLeaf() == 0){
                    getChilden(replyTreeDTO, elements ,mapper);
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

    private List<ReplyBean> getRootElements(List<ReplyBean> elements) {
        List<ReplyBean> roots=new ArrayList<ReplyBean>();
        for (ReplyBean element : elements) {
            if (element.getParentId() == -1) {
                roots.add(element);
            }
        }
        return roots;
    }

    /**
     * 回复管理审核状态的改变
     */
    @Override
    public int getCategory(long id) {
        String sql="update ReplyBean r set r.category = '1' where r.id ="+id;
        return dao.update(sql);
    }

    @Override
    public void deleteAllByPostid(long id) {
        dao.deleteAllByPostid(id);
    }

}
