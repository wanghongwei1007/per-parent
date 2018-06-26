package com.kalix.qiao.genealogy.entities;

import com.kalix.framework.core.api.persistence.PersistentEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Administrator on 2018/5/21 0021.
 */
@Entity
@Table(name = "qiao_genealogy_generation")
public class GenerationBean extends PersistentEntity {
    private String grade;//字辈
    private long genealogyId;// 家谱ID

    public long getGenealogyId() {
        return genealogyId;
    }

    public void setGenealogyId(long genealogyId) {
        this.genealogyId = genealogyId;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}
