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
@Table(name = "qiao_generation")
public class GenerationBean extends PersistentEntity {
    private String grade;//字辈

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}
