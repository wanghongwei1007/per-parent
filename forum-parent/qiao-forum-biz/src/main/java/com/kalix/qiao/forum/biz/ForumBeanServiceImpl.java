package com.kalix.qiao.forum.biz;

import com.kalix.framework.core.api.persistence.JsonData;
import com.kalix.framework.core.impl.biz.GenericBizServiceImpl;
import com.kalix.qiao.forum.api.biz.IForumBeanService;
import com.kalix.qiao.forum.api.dao.IForumBeanDao;
import com.kalix.qiao.forum.api.dto.ForumJsonBean;
import com.kalix.qiao.forum.entities.ForumBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sunli on 2018/5/13.
 */
public class ForumBeanServiceImpl extends GenericBizServiceImpl<IForumBeanDao, ForumBean> implements IForumBeanService {
    /**
     * 回复管理左侧菜单
     */
    @Override
    public JsonData getReplyForTree() {
        List<ForumJsonBean> list = new ArrayList<>();
        List<ForumBean> modelList = dao.find("select f from ForumBean f where f.category=1 order by f.timenow desc");
        if(modelList.size()>0){
            for (ForumBean forumBean:modelList){
                ForumJsonBean forumJsonBean = new ForumJsonBean();
                forumJsonBean.setValue(forumBean.getId());
                forumJsonBean.setLabel(forumBean.getTitle());
                list.add(forumJsonBean);
            }
        }
        JsonData jsonData = new JsonData();
        jsonData.setData(list);
        jsonData.setTotalCount((long)list.size());
        return jsonData;
    }
}
