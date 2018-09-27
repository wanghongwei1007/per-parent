package com.kalix.per.uio.entities;
import com.kalix.framework.core.api.persistence.PersistentEntity;

import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name = "per_uio_tes")
public class TesBean extends PersistentEntity {
    private  int r_num; // 题号
    private  String r_option; // 选择
    private  String r_answer; // 正确答案
    private  String r_result; // 结果
    private  int r_score;     // 分数
    private  String r_name;   // 名字

    public int getR_num() {
        return r_num;
    }

    public void setR_num(int r_num) {
        this.r_num=r_num;
    }

    public String getR_option() {
        return r_option;
    }

    public void setR_option(String r_option) {
        this.r_option=r_option;
    }

    public String getR_answer() {
        return r_answer;
    }

    public void setR_answer(String r_answer) {
        this.r_answer=r_answer;
    }

    public String getR_result() {
        return r_result;
    }

    public void setR_result(String r_result) {
        this.r_result=r_result;
    }

    public int getR_score() {
        return r_score;
    }

    public void setR_score(int r_score) {
        this.r_score=r_score;
    }

    public String getR_name() {
        return r_name;
    }

    public void setR_name(String r_name) {
        this.r_name=r_name;
    }
}