package com.kalix.qiao.system.district.entities;

import com.kalix.framework.core.api.persistence.PersistentEntity;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

/**
 * Created by Administrator on 2018/5/16.
 */
@Entity
@Table(name = "qiao_district")
@Inheritance(strategy = InheritanceType.JOINED)
public class DistrictBean extends PersistentEntity{
    private Integer coding;
    private String detail;
    private Integer parentencoding;

    public Integer getCoding() {
        return coding;
    }

    public void setCoding(Integer coding) {
        this.coding = coding;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public Integer getParentencoding() {
        return parentencoding;
    }

    public void setParentencoding(Integer parentencoding) {
        this.parentencoding = parentencoding;
    }
}
