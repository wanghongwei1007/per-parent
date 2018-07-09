package com.kalix.qiao.forum.biz;

import com.kalix.framework.core.api.persistence.JsonData;
import com.kalix.framework.core.impl.biz.GenericBizServiceImpl;
import com.kalix.qiao.forum.api.biz.IForumBeanService;
import com.kalix.qiao.forum.api.biz.IReplyBeanService;
import com.kalix.qiao.forum.api.dao.IForumBeanDao;
import com.kalix.qiao.forum.api.dto.ForumJsonBean;
import com.kalix.qiao.forum.entities.ForumBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sunli on 2018/5/13.
 */
public class ForumBeanServiceImpl extends GenericBizServiceImpl<IForumBeanDao, ForumBean> implements IForumBeanService {
    private IReplyBeanService iReplyBeanService;

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
                forumJsonBean.setContent(forumBean.getContent());
                list.add(forumJsonBean);
            }
        }
        JsonData jsonData = new JsonData();
        jsonData.setData(list);
        jsonData.setTotalCount((long)list.size());
        return jsonData;
    }
    /**
     * 留言管理审核状态
     */
    @Override
    public int getCategory(long id) {
        String sql="update ForumBean f set f.category = 1 where f.id ="+id;
        return dao.update(sql);
    }

    @Override
    public void deleteAllById(long id) {
        dao.remove(id);
        iReplyBeanService.deleteAllByPostid(id);
    }

    public void setiReplyBeanService(IReplyBeanService iReplyBeanService) {
        this.iReplyBeanService = iReplyBeanService;
    }
}
