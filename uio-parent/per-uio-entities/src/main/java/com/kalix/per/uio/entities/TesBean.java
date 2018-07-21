package com.kalix.per.uio.entities;
import com.kalix.framework.core.api.persistence.PersistentEntity;

import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name = "per_uio_tes")
public class TesBean extends PersistentEntity {
    private  String r_num; // 题号
    private  String r_option; // 选择
    private  String r_answer; // 正确答案
    private  String r_result; // 结果

    public String getR_num() {
        return r_num;
    }

    public void setR_num(String r_num) {
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
}