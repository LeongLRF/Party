package com.wyu.partymanager.entity;

import com.alibaba.fastjson.JSON;

public interface JsonEntity extends IEntity {
    default String toJson() {
        return JSON.toJSONString(this);
    }

    default String key() {
        return this.getClass().getName() + this.getId();
    }
}
