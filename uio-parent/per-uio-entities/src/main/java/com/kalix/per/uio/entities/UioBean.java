package com.kalix.per.uio.entities;

import com.kalix.framework.core.api.persistence.PersistentEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;



@Entity
@Table(name = "per_uio")
public class UioBean extends PersistentEntity {
    @Column(name = "topic", columnDefinition = "text")
    private  String topic;
    private  String a_option;
    private  String b_option;
    private  String c_option;
    private  String d_option;
    private  String Correct;
    private  String q_number;

    public String getQ_number() {
        return q_number;
    }

    public void setQ_number(String q_number) {
        this.q_number = q_number;
    }

    public String getCorrect() {
        return Correct;
    }

    public void setCorrect(String correct) {
        Correct = correct;
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

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

}