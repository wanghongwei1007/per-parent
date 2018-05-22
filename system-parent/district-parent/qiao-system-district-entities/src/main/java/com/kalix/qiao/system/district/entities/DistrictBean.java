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
    private Integer encoding;
    private String describe;
    private Integer parentencoding;

    public Integer getEncoding() {
        return encoding;
    }

    public void setEncoding(Integer encoding) {
        this.encoding = encoding;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public Integer getParentencoding() {
        return parentencoding;
    }

    public void setParentencoding(Integer parentencoding) {
        this.parentencoding = parentencoding;
    }
}
