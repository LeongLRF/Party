package com.wyu.partymanager.entity.sys;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.wyu.partymanager.entity.JsonEntity;
import io.swagger.annotations.ApiModel;
import lombok.Data;

@Data
@ApiModel
@TableName("sys_clazz")
public class Clazz implements JsonEntity {

    @TableId(value = "id",type = IdType.AUTO)
    long id;

}
