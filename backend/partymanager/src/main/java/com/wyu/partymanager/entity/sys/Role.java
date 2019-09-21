package com.wyu.partymanager.entity.sys;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.wyu.partymanager.entity.TimestampEntity;
import lombok.Data;

import java.sql.Timestamp;

/**
 * @author Leong
 * @date 2019/9/21 13:23
 */
@Data
@TableName("sys_role")
public class Role implements TimestampEntity {

    @TableField("id")
    long id;
    @TableField("name")
    String name;
    @TableField("permission")
    String permission;
    @TableField("insertedAt")
    Timestamp insertedAt;
    @TableField("updatedAt")
    Timestamp updatedAt;

}
