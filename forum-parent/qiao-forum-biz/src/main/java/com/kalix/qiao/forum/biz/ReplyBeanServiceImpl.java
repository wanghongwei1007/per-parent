package com.kalix.qiao.forum.biz;

import com.kalix.framework.core.impl.biz.GenericBizServiceImpl;
import com.kalix.qiao.forum.api.biz.IReplyBeanService;
import com.kalix.qiao.forum.api.dao.IReplyBeanDao;
import com.kalix.qiao.forum.api.dto.ReplyForTreeTable;
import com.kalix.qiao.forum.entities.ReplyBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sunli on 2018/5/13.
 */
public class ReplyBeanServiceImpl extends GenericBizServiceImpl<IReplyBeanDao, ReplyBean> implements IReplyBeanService {
   /* @Override
    public ReplyForTreeTable getReplyByPostId(long postId) {
        ReplyForTreeTable rtt = new ReplyForTreeTable();
        if(postId == -1){
          *//*  List<ReplyBean>  replyBeans = dao.getAll().stream()
                    .sorted(Compare.<ReplyBean>compare())
                    .collect();*//*
        }
        return null;
    }
*/
   @Override
    public ReplyForTreeTable getReplyByPostId(long postId) {
        ReplyForTreeTable  rtt = new ReplyForTreeTable();
        List<ReplyForTreeTable> list = new ArrayList<>();
        List<ReplyBean> replyBeanList = new ArrayList<>();
        if(postId==-1){
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
    public List<ReplyForTreeTable> getReplyByParentId(ReplyBean replyBean){
        ReplyForTreeTable rtt = new ReplyForTreeTable();
        List<ReplyForTreeTable> list = new ArrayList<>();
        List<ReplyForTreeTable> childrenList= new ArrayList<>();
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
        /*List<ReplyForTreeTable> childrenList = new ArrayList<>();
        for(ReplyBean replyBean1 : childList){
            ReplyForTreeTable rt = new ReplyForTreeTable();
            childrenList = getReplyByParentId(replyBean1,rt,list);
            if(childrenList.size() > 1){
                ReplyForTreeTable rtt = new ReplyForTreeTable();
                childrenList = getReplyByParentId(replyBean1,rtt,list);
                replyForTreeTable.setChildren(childrenList);
            }else if(childrenList.size() == 1){
                replyForTreeTable = childrenList.get(0);
            }else{
            }
        }*/
    }
}
