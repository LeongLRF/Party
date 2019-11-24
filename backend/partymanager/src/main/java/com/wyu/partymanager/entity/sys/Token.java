package com.wyu.partymanager.entity.sys;

import annotation.Column;
import annotation.Id;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import util.IdType;

import java.io.Serializable;

/**
 * @author Leong
 */
@Data
@TableName("sys_token")
@ApiModel
public class Token implements Serializable {

    @TableId("token")
    @Id(value = "token", type = IdType.UNDEFINE)
    String token;

    @TableField("userId")
    @Column("userId")
    long userId;
}
