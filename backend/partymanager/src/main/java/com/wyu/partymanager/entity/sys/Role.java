package com.wyu.partymanager.entity.sys;

import annotation.Column;
import annotation.Id;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.wyu.partymanager.entity.IEntity;
import com.wyu.partymanager.entity.JsonEntity;
import com.wyu.partymanager.entity.TimestampEntity;
import com.wyu.partymanager.utils.IFilter;
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

    @EqualsAndHashCode(callSuper = true)
    @Data
    public static class Filter extends IFilter<Role> {

        @ApiModelProperty("过滤名称")
        String name;

        @Override
        public Wrapper<Role> apply() {
            return this.queryWrapper();
        }
    }

}
