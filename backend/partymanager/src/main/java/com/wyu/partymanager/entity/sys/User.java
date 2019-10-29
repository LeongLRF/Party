package com.wyu.partymanager.entity.sys;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.wyu.partymanager.entity.JsonEntity;
import com.wyu.partymanager.entity.pm.TakePart;
import com.wyu.partymanager.utils.IFilter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.sql.Timestamp;
import java.util.List;

/**
 * @author Leong
 * @date 2019/9/15 23:10
 */

@Data
@ApiModel
@TableName("sys_user")
public class User implements JsonEntity {

    @TableId(value = "id", type = IdType.AUTO)
    long id;

    @TableField("userName")
    @ApiModelProperty("学号或教工号")
    String userName;

    @TableField("password")
    @ApiModelProperty("密码")
    String password;

    @ApiModelProperty("性别")
    @TableField("sex")
    String sex;

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

    @TableField("salt")
    @ApiModelProperty("salt")
    String salt;

    @ApiModelProperty("token")
    @TableField("token")
    String token;

    @ApiModelProperty("是否被冻结")
    @TableField("valid")
    boolean valid;

    @ApiModelProperty("'籍贯")
    @TableField("homeTown")
    String homeTown;

    @ApiModelProperty("婚姻状况")
    @TableField("marry")
    String marry;

    @ApiModelProperty("入党时所在支部")
    @TableField("takePartDept")
    String takePartDept;

    @ApiModelProperty("转正时所在支部")
    @TableField("formalDept")
    String formalDept;

    @ApiModelProperty("毕业院校系及专业")
    @TableField("schoolMajor")
    String schoolMajor;

    @ApiModelProperty("工作单位及职位")
    @TableField("workPlace")
    String workPlace;

    @ApiModelProperty("组织关系所在单位")
    @TableField("relationship")
    String relationship;

    @ApiModelProperty("户籍所在地")
    @TableField("home")
    String home;

    @ApiModelProperty("qq或微信号")
    @TableField("account")
    String account;

    @ApiModelProperty("现居地")
    @TableField("currentHome")
    String currentHome;


    @TableField(exist = false)
    Role role;

    @TableField(exist = false)
    Dept dept;

    @TableField(exist = false)
    Clazz clazz;

    @TableField(exist = false)
    List<TakePart> takeParts;

    @EqualsAndHashCode(callSuper = true)
    @Data
    public static class Filter extends IFilter<User> {
        @ApiModelProperty("过滤姓名")
        String name;

        @Override
        public QueryWrapper<User> apply() {
            return this.queryWrapper().like(name != null, "trueName", name);
        }
    }

}
