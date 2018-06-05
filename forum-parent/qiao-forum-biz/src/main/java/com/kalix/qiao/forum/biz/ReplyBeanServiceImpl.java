package com.kalix.qiao.forum.biz;

import com.kalix.framework.core.impl.biz.GenericBizServiceImpl;
import com.kalix.qiao.forum.api.biz.IReplyBeanService;
import com.kalix.qiao.forum.api.dao.IReplyBeanDao;
import com.kalix.qiao.forum.api.dto.ReplyForTreeTable;
import com.kalix.qiao.forum.entities.ReplyBean;
import com.kalix.qiao.forum.util.Compare;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sunli on 2018/5/13.
 */
public class ReplyBeanServiceImpl extends GenericBizServiceImpl<IReplyBeanDao, ReplyBean> implements IReplyBeanService {

    @Override
    public ReplyForTreeTable getReplyByPostId(long postId) {
        ReplyForTreeTable rtt = new ReplyForTreeTable();
        if(postId == -1){
          /*  List<ReplyBean>  replyBeans = dao.getAll().stream()
                    .sorted(Compare.<ReplyBean>compare())
                    .collect();*/
        }

        return null;

    }



    /*public ReplyForTreeTable getReplyByPostId(long postId) {
        ReplyForTreeTable  rtt = new ReplyForTreeTable();
        List<ReplyForTreeTable> list = new ArrayList<>();
        List<ReplyBean> replyBeanList = new ArrayList<>();
        if(postId==-1){
            replyBeanList = dao.find("select r from ReplyBean r where r.category='0' and r.parentId=-1 order by r.creationDate desc");
        }else{
            replyBeanList = dao.find("select r from ReplyBean r where r.postId =?1 order by r.creationDate desc", postId);
        }
        if(replyBeanList.size()>0){
            List<ReplyForTreeTable> childList = new ArrayList<>();
            for(ReplyBean replyBean:replyBeanList){
                ReplyForTreeTable replyForTreeTable = new ReplyForTreeTable();
                list = getReplyByParentId(replyBean,replyForTreeTable, childList);
            }
        }
        rtt.setChildren(list);
        return rtt;
    }

    private List<ReplyForTreeTable> getReplyByParentId(ReplyBean replyBean,ReplyForTreeTable replyForTreeTable, List<ReplyForTreeTable> list){
        replyForTreeTable.setId(replyBean.getId());
        replyForTreeTable.setUsername(replyBean.getUsername());
        replyForTreeTable.setCreationDate(replyBean.getCreationDate());
        replyForTreeTable.setContent(replyBean.getContent());
        replyForTreeTable.setCategory(replyBean.getCategory());
        replyForTreeTable.setParentId(replyBean.getParentId());
        List<ReplyBean> childList = dao.find("select r from ReplyBean r where r.parentId=?1", replyBean.getId());
        if(childList.size()>0){
            List<ReplyForTreeTable> childrenList = new ArrayList<>();
            for(ReplyBean replyBean1 : childList){
                ReplyForTreeTable rt = new ReplyForTreeTable();
                childrenList = getReplyByParentId(replyBean1,rt,list);
            }
            replyForTreeTable.setChildren(childrenList);
        }
        list.add(replyForTreeTable);
        return list;
    }*/
}
