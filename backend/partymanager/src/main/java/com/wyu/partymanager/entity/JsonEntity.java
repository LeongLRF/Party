package com.wyu.partymanager.entity;

import com.alibaba.fastjson.JSON;

public interface JsonEntity {
    default String toJson(){
        return JSON.toJSONString(this);
    }
}
