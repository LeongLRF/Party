package com.wyu.partymanager.entity.pm;

import annotation.Column;
import annotation.Id;
import annotation.Table;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.sun.javafx.beans.IDProperty;
import com.wyu.partymanager.entity.JsonEntity;
import com.wyu.partymanager.entity.sys.Type;
import com.wyu.partymanager.entity.sys.User;
import core.inerface.IFilter;
import core.inerface.ISelectQuery;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.validator.constraints.URL;

import java.sql.Timestamp;
import java.util.List;

/**
 * @author Leong
 */
@Data
@TableName("pm_activity")
@Table("pm_activity")
public class Activity implements JsonEntity {

    @TableId(value = "id", type = IdType.AUTO)
    @Id(value = "id", type = util.IdType.AUTO)
    long id;

    @ApiModelProperty("日期")
    @TableField("start")
    @Column("start")
    Timestamp start;

    @ApiModelProperty("大类")
    @TableField("typeId")
    @Column("typeId")
    long typeId;

    @ApiModelProperty("方式")
    @TableField("way")
    @Column("way")
    String way;

    @ApiModelProperty("活动内容")
    @TableField("content")
    @Column("content")
    String content;

    @ApiModelProperty("地点")
    @TableField("place")
    @Column("place")
    String place;

    @ApiModelProperty("holder")
    @TableField("holder")
    @Column("holder")
    String holder;

    @ApiModelProperty("speaker")
    @TableField("speaker")
    @Column("speaker")
    String speaker;

    @ApiModelProperty("备注")
    @TableField("remark")
    @Column("remark")
    String remark;

    @ApiModelProperty("学时")
    @TableField("hours")
    @Column("hours")
    int hours;

    @ApiModelProperty("组织单位")
    @TableField("deptId")
    @Column("deptId")
    long deptId;

    @ApiModelProperty("活动类别")
    @TableField(exist = false)
    Type type;

    @TableField(exist = false)
    List<TakePart> takeParts;

    @Data
    public static class Filter implements IFilter<Activity> {


        @Override
        public ISelectQuery<Activity> apply(ISelectQuery<Activity> iSelectQuery) {
            return iSelectQuery;
        }
    }
}
