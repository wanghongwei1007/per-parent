package com.kalix.qiao.forum.biz;

import com.kalix.framework.core.impl.biz.GenericBizServiceImpl;
import com.kalix.qiao.forum.api.biz.IReplyBeanService;
import com.kalix.qiao.forum.api.dao.IReplyBeanDao;
import com.kalix.qiao.forum.api.dto.ReplyTreeDTO;
import com.kalix.qiao.forum.entities.ReplyBean;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sunli on 2018/5/23.
 */
public class ReplyBeanServiceImpl extends GenericBizServiceImpl<IReplyBeanDao, ReplyBean> implements IReplyBeanService {
    @Override
    public ReplyTreeDTO getReplyByPostId(long postId) {
        ReplyTreeDTO root = new ReplyTreeDTO();
        root.setId(-1L);
        List<ReplyBean> beans = new ArrayList<>();
        if(postId == -1){
            beans = dao.getAll();
        }else{
            beans = dao.find("select r from ReplyBean r where r.postId =?1 order by r.creationDate desc", postId);
        }
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


   /* @Override
    public ReplyTreeDTO getReplyByPostId(long postId) {
        ReplyTreeDTO  rtt = new ReplyTreeDTO();
        List<ReplyTreeDTO> list = new ArrayList<>();
        List<ReplyBean> replyBeanList = new ArrayList<>();
        if(postId == -1){
            replyBeanList = dao.find("select r from ReplyBean r where r.category='0' and r.parentId=-1 order by r.creationDate desc");
        }else{
            replyBeanList = dao.find("select r from ReplyBean r where r.postId =?1 order by r.creationDate desc", postId);
        }
        if(replyBeanList.size()>0){
            for(ReplyBean replyBean:replyBeanList){
                list = getReplyByParentId(replyBean);
            }
        }
       rtt.setChildren(list);
        return rtt;
    }

    @Override
    public List<ReplyTreeDTO> getReplyByParentId(ReplyBean replyBean){
        ReplyTreeDTO rtt = new ReplyTreeDTO();
        List<ReplyTreeDTO> list = new ArrayList<>();
        List<ReplyTreeDTO> childrenList= new ArrayList<>();
        rtt.setId(replyBean.getId());
        rtt.setUsername(replyBean.getUsername());
        rtt.setCreationDate(replyBean.getCreationDate());
        rtt.setContent(replyBean.getContent());
        rtt.setCategory(replyBean.getCategory());
        rtt.setParentId(replyBean.getParentId());
        rtt.setLeaf(true);
        List<ReplyBean> childList = dao.find("select r from ReplyBean r where r.parentId=?1 order by r.creationDate desc", replyBean.getId());
        if(childList.size()>0){
            for(ReplyBean replyBean1 : childList){
                childrenList = getReplyByParentId(replyBean1);
            }
            rtt.setLeaf(false);
        }
        rtt.setChildren(childrenList);
        list.add(rtt);
        return list;
    }*/
}
