package com.wyu.partymanager.entity.pm;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.wyu.partymanager.entity.IEntity;
import com.wyu.partymanager.utils.IFilter;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.sql.Timestamp;
import java.util.List;

@Data
@TableName("pm_activity")
public class Activity implements IEntity {

    @TableId(value = "id",type = IdType.AUTO)
    long id;

    @ApiModelProperty("日期")
    @TableField("start")
    Timestamp start;

    @ApiModelProperty("大类")
    @TableField("type")
    String type;

    @ApiModelProperty("方式")
    @TableField("way")
    String way;

    @ApiModelProperty("主题,用‘,’隔开")
    @TableField(value = "theme")
    String theme;

    @ApiModelProperty("参加人员")
    @TableField(value = "details")
    List<Details> details;

    @ApiModelProperty("活动内容")
    @TableField("content")
    String content;

    @ApiModelProperty("地点")
    @TableField("place")
    String place;

    @ApiModelProperty("holder")
    @TableField("holder")
    String holder;

    @ApiModelProperty("speaker")
    @TableField("speaker")
    String speaker;

    @ApiModelProperty("备注")
    @TableField("remark")
    String remark;

    @ApiModelProperty("学时")
    @TableField("hours")
    int hours;

    @Data
    public static class Details{
        @ApiModelProperty("参加人员Id")
        long id;
        @ApiModelProperty("参加人员姓名")
        String name;
    }

    @EqualsAndHashCode(callSuper = true)
    @Data
    public static class Filter extends IFilter<Activity> {

        @Override
        public Wrapper<Activity> apply() {
            return this.getQueryWrapper();
        }
    }
}
