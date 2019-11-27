package com.wyu.partymanager.entity.sys;

import annotation.Column;
import annotation.Id;
import annotation.Table;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.wyu.partymanager.entity.IEntity;
import com.wyu.partymanager.entity.JsonEntity;
import com.wyu.partymanager.entity.TimestampEntity;
import core.inerface.IFilter;
import core.inerface.ISelectQuery;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.sql.Timestamp;

/**
 * @author Leong
 * @date 2019/9/21 13:23
 */
@Data
@TableName("sys_role")
@Table(value = "sys_role",cache = true,expireTime = 60 * 60 * 24 * 365)
public class Role implements JsonEntity {

    @TableId(value = "id", type = IdType.AUTO)
    @Id(value = "id", type = util.IdType.AUTO)
    long id;
    @TableField("name")
    @Column("name")
    String name;
    @TableField("permission")
    @Column("permission")
    String permission;
    @TableField("valid")
    @Column("valid")
    boolean valid;

    @Data
    public static class Filter implements IFilter<Role> {

        @Override
        public ISelectQuery<Role> apply(ISelectQuery<Role> iSelectQuery) {
            return iSelectQuery;
        }
    }

}
