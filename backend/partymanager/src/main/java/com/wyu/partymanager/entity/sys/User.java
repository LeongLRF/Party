package com.wyu.partymanager.entity.sys;

import annotation.Column;
import annotation.Id;
import annotation.Table;
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
@Table("sys_user")
public class User implements JsonEntity {

    @Id(value = "id",idType = util.IdType.AUTO)
    @TableId(value = "id", type = IdType.AUTO)
    long id;

    @Column( "userName")
    @TableField("userName")
    @ApiModelProperty("学号或教工号")
    String userName;

    @TableField("password")
    @ApiModelProperty("密码")
    @Column( "password")
    String password;

    @ApiModelProperty("性别")
    @Column( "sex")
    @TableField("sex")
    String sex;

    @TableField("roleId")
    @Column( "roleId")
    @ApiModelProperty("角色id")
    long roleId;

    @TableField("classId")
    @Column( "classId")
    @ApiModelProperty("班级id")
    long classId;

    @TableField("deptId")
    @Column( "deptId")
    @ApiModelProperty("支部id")
    long deptId;

    @TableField("trueName")
    @Column( "trueName")
    @ApiModelProperty("真实姓名")
    String trueName;

    @TableField("birthday")
    @Column( "birthday")
    @ApiModelProperty("出生年月")
    Timestamp birthday;

    @TableField("nation")
    @Column( "nation")
    @ApiModelProperty("民族")
    String nation;

    @TableField("joinTime")
    @Column( "joinTime")
    @ApiModelProperty("入党时间")
    Timestamp joinTime;

    @TableField("formalTime")
    @Column( "formalTime")
    @ApiModelProperty("转正时间")
    Timestamp formalTime;

    @TableField("workTime")
    @Column( "workTime")
    @ApiModelProperty("参加工作时间")
    Timestamp workTime;

    @TableField("joinPeople")
    @Column( "joinPeople")
    @ApiModelProperty("入党介绍人")
    String joinPeople;

    @TableField("academicId")
    @Column( "academicId")
    @ApiModelProperty("学院Id")
    long academicId;

    @TableField("joinDeptTime")
    @Column( "JoinDeptTime")
    @ApiModelProperty("进入党支部时间")
    Timestamp joinDeptTime;

    @TableField("currentPosition")
    @Column( "currentPosition")
    @ApiModelProperty("现任职务")
    String currentPosition;

    @TableField("degree")
    @Column( "degree")
    @ApiModelProperty("学位学历")
    String degree;

    @TableField("idCard")
    @Column( "idCard")
    @ApiModelProperty("身份证号")
    String idCard;

    @TableField("phone")
    @Column( "phone")
    @ApiModelProperty("联系电话")
    String phone;

    @TableField("salt")
    @Column( "salt")
    @ApiModelProperty("salt")
    String salt;

    @ApiModelProperty("是否被冻结")
    @TableField("valid")
    @Column( "valid")
    boolean valid;

    @ApiModelProperty("'籍贯")
    @TableField("homeTown")
    @Column( "homeTown")
    String homeTown;

    @ApiModelProperty("婚姻状况")
    @TableField("marry")
    @Column( "marry")
    String marry;

    @ApiModelProperty("入党时所在支部")
    @TableField("takePartDept")
    @Column( "takePartDept")
    String takePartDept;

    @ApiModelProperty("转正时所在支部")
    @TableField("formalDept")
    @Column( "formalDept")
    String formalDept;

    @ApiModelProperty("毕业院校系及专")
    @TableField("schoolMajor")
    @Column( "schoolMajor")
    String schoolMajor;

    @ApiModelProperty("工作单位及职位")
    @TableField("workPlace")
    @Column( "workPlace")
    String workPlace;

    @ApiModelProperty("组织关系所在单位")
    @TableField("relationship")
    @Column( "relationship")
    String relationship;

    @ApiModelProperty("户籍所在地")
    @TableField("home")
    @Column( "home")
    String home;

    @ApiModelProperty("qq或微信号")
    @TableField("account")
    @Column( "account")
    String account;

    @ApiModelProperty("现居地")
    @TableField("currentHome")
    @Column( "currentHome")
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
