package com.kalix.per.uio.entities;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.kalix.framework.core.api.persistence.PersistentEntity;

import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name = "per_uio")
public class UioBean extends PersistentEntity {
    private  String topic;//题

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }
}