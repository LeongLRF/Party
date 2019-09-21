package com.wyu.partymanager.entity.sys;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.wyu.partymanager.entity.IEntity;
import com.wyu.partymanager.utils.IFilter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @author Leong
 * @date 2019/9/15 23:10
 */

@Data
@ApiModel
@TableName("sys_user")
public class User implements Serializable, IEntity {

    @TableId(value = "id", type = IdType.AUTO)
    long id;
    @TableField("userName")
    @ApiModelProperty("学号或教工号")
    String userName;

    @TableField("password")
    @ApiModelProperty("密码")
    String password;

    @TableField("roleId")
    @ApiModelProperty("角色id")
    long roleId;

    @TableField("classId")
    @ApiModelProperty("班级id")
    long classId;

    @TableField("deptId")
    @ApiModelProperty("支部id")
    long deptId;

    @TableField("trueName")
    @ApiModelProperty("真实姓名")
    String trueName;

    @TableField("birthday")
    @ApiModelProperty("出生年月")
    Timestamp birthday;

    @TableField("nation")
    @ApiModelProperty("民族")
    String nation;

    @TableField("joinTime")
    @ApiModelProperty("入党时间")
    Timestamp joinTime;

    @TableField("formalTime")
    @ApiModelProperty("转正时间")
    Timestamp formalTime;

    @TableField("workTime")
    @ApiModelProperty("参加工作时间")
    Timestamp workTime;

    @TableField("joinPeople")
    @ApiModelProperty("入党介绍人")
    String joinPeople;

    @TableField("academicId")
    @ApiModelProperty("学院Id")
    long academicId;

    @TableField("joinDeptTime")
    @ApiModelProperty("进入党支部时间")
    Timestamp joinDeptTime;

    @TableField("currentPosition")
    @ApiModelProperty("现任职务")
    String currentPosition;

    @TableField("degree")
    @ApiModelProperty("学位学历")
    String degree;

    @TableField("idCard")
    @ApiModelProperty("身份证号")
    String idCard;

    @TableField("phone")
    @ApiModelProperty("联系电话")
    String phone;

    @Data
    public static class Filter implements IFilter<User>{
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        String name;


        @Override
        public QueryWrapper<User> apply() {
            return this.queryWrapper.like(name!=null,"trueName",name);
        }
    }

}
