package com.kalix.per.regc.entities;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.kalix.framework.core.api.persistence.PersistentEntity;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;


@Entity
@Table(name = "per_reg")
public class RegBean extends PersistentEntity {
    private  String name;
    private  String tel;
    private  String school;
    private  String major;//专业
    private  String position;//岗位
    private  String education;//学历
    @JsonFormat(shape=JsonFormat.Shape.STRING,pattern="yyyy-MM-dd",timezone="GMT+8")
    private  Date time;
    private  int score;

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score=score;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }




    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }




}