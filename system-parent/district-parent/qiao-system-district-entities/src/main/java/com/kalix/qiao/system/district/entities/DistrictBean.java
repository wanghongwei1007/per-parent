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
    private String coding;
    private String bewrite;
    private String parentencoding;

    public String getCoding() {
        return coding;
    }

    public void setCoding(String coding) {
        this.coding = coding;
    }

    public String getBewrite() {
        return bewrite;
    }

    public void setBewrite(String bewrite) {
        this.bewrite = bewrite;
    }

    public String getParentencoding() {
        return parentencoding;
    }

    public void setParentencoding(String parentencoding) {
        this.parentencoding = parentencoding;
    }
}
