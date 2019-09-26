package com.wyu.partymanager.entity.sys;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.wyu.partymanager.entity.IEntity;
import com.wyu.partymanager.entity.TimestampEntity;
import com.wyu.partymanager.utils.IFilter;
import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @author Leong
 * @date 2019/9/21 13:23
 */
@Data
@TableName("sys_role")
public class Role implements TimestampEntity , Serializable , IEntity {

    @TableId(value = "id",type = IdType.AUTO)
    long id;
    @TableField("name")
    String name;
    @TableField("permission")
    String permission;
    @TableField("insertedAt")
    Timestamp insertedAt;
    @TableField("updatedAt")
    Timestamp updatedAt;

    @Data
    public static class Filter implements IFilter<Role>{
        @JsonIgnore
        QueryWrapper<Role> queryWrapper = new QueryWrapper<>();


        @Override
        public Wrapper<Role> apply() {
            return this.queryWrapper;
        }
    }

}
