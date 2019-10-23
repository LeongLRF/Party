package com.wyu.partymanager.entity.sys;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("sys_token")
@ApiModel
public class Token implements Serializable {

    @TableId("token")
    String token;

    @TableField("userId")
    long userId;
}
