package com.kalix.qiao.genealogy.entities;

import com.kalix.framework.core.api.persistence.PersistentEntity;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.DateTimeException;
import java.util.Date;
/**
 * Created by Administrator on 2018/5/21 0021.
 */
@Entity
@Table(name="qiao_genealogy_kinsfolk")
public class KinsfolkBean extends PersistentEntity{
    private String name;//关系人姓名
    private int category;//字典表关系

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }
}
