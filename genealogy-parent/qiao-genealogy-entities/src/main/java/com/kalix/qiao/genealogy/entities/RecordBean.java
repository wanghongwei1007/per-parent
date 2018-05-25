package com.kalix.qiao.genealogy.entities;

import com.kalix.framework.core.api.persistence.PersistentEntity;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by Administrator on 2018/5/21 0021.
 */
@Entity
@Table(name = "qiao_genealogy_record")
public class RecordBean extends PersistentEntity {
    private String category;//记录类型
    private String chronicle;//族人纪事描述
    private int member;//族人id
    private String site;//纪念地址
    private Date time;//纪念日期

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getChronicle() {
        return chronicle;
    }

    public void setChronicle(String chronicle) {
        this.chronicle = chronicle;
    }

    public int getMember() {
        return member;
    }

    public void setMember(int member) {
        this.member = member;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
