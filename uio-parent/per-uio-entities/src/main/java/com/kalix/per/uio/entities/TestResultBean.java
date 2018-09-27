package com.kalix.per.uio.entities;

import com.kalix.framework.core.api.persistence.PersistentEntity;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class TestResultBean extends PersistentEntity {

    @Column(name = "topic", columnDefinition = "text")
    private  String topic;
    private  String a_option;
    private  String b_option;
    private  String c_option;
    private  String d_option;
    private  String Correct;
    private  int q_number;
    private  String r_option; // 选择
    private  int r_score;     // 分数

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getA_option() {
        return a_option;
    }

    public void setA_option(String a_option) {
        this.a_option = a_option;
    }

    public String getB_option() {
        return b_option;
    }

    public void setB_option(String b_option) {
        this.b_option = b_option;
    }

    public String getC_option() {
        return c_option;
    }

    public void setC_option(String c_option) {
        this.c_option = c_option;
    }

    public String getD_option() {
        return d_option;
    }

    public void setD_option(String d_option) {
        this.d_option = d_option;
    }

    public String getCorrect() {
        return Correct;
    }

    public void setCorrect(String correct) {
        Correct = correct;
    }

    public int getQ_number() {
        return q_number;
    }

    public void setQ_number(int q_number) {
        this.q_number = q_number;
    }

    public String getR_option() {
        return r_option;
    }

    public void setR_option(String r_option) {
        this.r_option = r_option;
    }

    public int getR_score() {
        return r_score;
    }

    public void setR_score(int r_score) {
        this.r_score = r_score;
    }
}
