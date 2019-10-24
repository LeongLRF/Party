package com.wyu.partymanager.entity.pm;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.wyu.partymanager.entity.JsonEntity;
import com.wyu.partymanager.entity.sys.Type;
import com.wyu.partymanager.entity.sys.User;
import com.wyu.partymanager.utils.IFilter;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.validator.constraints.URL;

import java.sql.Timestamp;
import java.util.List;

@Data
@TableName("pm_activity")
public class Activity implements JsonEntity {

    @TableId(value = "id", type = IdType.AUTO)
    long id;

    @ApiModelProperty("日期")
    @TableField("start")
    Timestamp start;

    @ApiModelProperty("大类")
    @TableField("typeId")
    long typeId;

    @ApiModelProperty("方式")
    @TableField("way")
    String way;

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

    @ApiModelProperty("组织单位")
    @TableField("deptId")
    long deptId;

    @ApiModelProperty("活动类别")
    @TableField(exist = false)
    Type type;

    @TableField(exist = false)
    List<TakePart> takeParts;

    @EqualsAndHashCode(callSuper = true)
    @Data
    public static class Filter extends IFilter<Activity> {

        @Override
        public Wrapper<Activity> apply() {
            return this.queryWrapper();
        }
    }
}
