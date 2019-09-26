package com.wyu.partymanager.entity.sys;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.wyu.partymanager.entity.IEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.apache.ibatis.type.JdbcType;

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
    @TableField(value = "details",jdbcType = JdbcType.ARRAY)
    List<Details> details;

    @Data
    public static class Details{
        @ApiModelProperty("参加人员Id")
        long id;
        @ApiModelProperty("参加人员姓名")
        String name;
    }
}
