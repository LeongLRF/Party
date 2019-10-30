package com.wyu.partymanager.entity.sys;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.wyu.partymanager.entity.JsonEntity;
import com.wyu.partymanager.utils.IFilter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@ApiModel
@TableName("pm_clazz")
public class Clazz implements JsonEntity {

    @TableId(value = "id",type = IdType.AUTO)
    long id;

    @ApiModelProperty("班级号")
    @TableField("code")
    String code;

    @ApiModelProperty("班级名称")
    @TableField("name")
    String name;

    @ApiModelProperty("班级专业")
    @TableField("major")
    String major;

    @ApiModelProperty("总人数")
    @TableField("total")
    int total;

    @ApiModelProperty("班导师")
    @TableField("teacher")
    String teacher;

    @EqualsAndHashCode(callSuper = true)
    @Data
    public static class Filter extends IFilter<Clazz>{

        @Override
        public Wrapper<Clazz> apply() {
            return this.queryWrapper();
        }
    }

}
