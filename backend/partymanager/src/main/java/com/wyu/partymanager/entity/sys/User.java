package com.wyu.partymanager.entity.sys;

import annotation.Column;
import annotation.Id;
import annotation.Table;

import com.wyu.partymanager.entity.JsonEntity;
import com.wyu.partymanager.entity.pm.TakePart;
import core.inerface.IFilter;
import core.inerface.ISelectQuery;
import core.support.IdType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.sql.Timestamp;
import java.util.List;

/**
 * @author Leong
 * @date 2019/9/15 23:10
 */

@Data
@ApiModel
@Table(value = "sys_user", cache = true, expireTime = 60 * 60 * 24 * 3)
public class User implements JsonEntity {

    @Id(value = "id", idType = IdType.AUTO)
    long id;

    @Column("userName")
    @ApiModelProperty("学号或教工号")
    String userName;

    @ApiModelProperty("密码")
    @Column("password")
    String password;

    @ApiModelProperty("性别")
    @Column("sex")
    String sex;


    @Column("roleId")
    @ApiModelProperty("角色id")
    long roleId;

    @Column("classId")
    @ApiModelProperty("班级id")
    Long classId;

    @Column("deptId")
    @ApiModelProperty("支部id")
    Long deptId;

    @Column("trueName")
    @ApiModelProperty("真实姓名")
    String trueName;

    @Column("birthday")
    @ApiModelProperty("出生年月")
    Timestamp birthday;

    @Column("nation")
    @ApiModelProperty("民族")
    String nation;

    @Column("joinTime")
    @ApiModelProperty("入党时间")
    Timestamp joinTime;

    @Column("formalTime")
    @ApiModelProperty("转正时间")
    Timestamp formalTime;

    @Column("workTime")
    @ApiModelProperty("参加工作时间")
    Timestamp workTime;

    @Column("joinPeople")
    @ApiModelProperty("入党介绍人")
    String joinPeople;

    @Column("academicId")
    @ApiModelProperty("学院Id")
    long academicId;

    @Column("JoinDeptTime")
    @ApiModelProperty("进入党支部时间")
    Timestamp joinDeptTime;

    @Column("currentPosition")
    @ApiModelProperty("现任职务")
    String currentPosition;

    @Column("degree")
    @ApiModelProperty("学位学历")
    String degree;

    @Column("idCard")
    @ApiModelProperty("身份证号")
    String idCard;

    @Column("phone")
    @ApiModelProperty("联系电话")
    String phone;

    @Column("salt")
    @ApiModelProperty("salt")
    String salt;

    @ApiModelProperty("是否被冻结")
    @Column("valid")
    boolean valid;

    @ApiModelProperty("'籍贯")
    @Column("homeTown")
    String homeTown;

    @ApiModelProperty("婚姻状况")
    @Column("marry")
    String marry;

    @ApiModelProperty("入党时所在支部")
    @Column("takePartDept")
    String takePartDept;

    @ApiModelProperty("转正时所在支部")
    @Column("formalDept")
    String formalDept;

    @ApiModelProperty("毕业院校系及专")
    @Column("schoolMajor")
    String schoolMajor;

    @ApiModelProperty("工作单位及职位")
    @Column("workPlace")
    String workPlace;

    @ApiModelProperty("组织关系所在单位")
    @Column("relationship")
    String relationship;

    @ApiModelProperty("户籍所在地")
    @Column("home")
    String home;

    @ApiModelProperty("qq或微信号")
    @Column("account")
    String account;

    @ApiModelProperty("现居地")
    @Column("currentHome")
    String currentHome;


    Role role;

    Dept dept;

    Clazz clazz;

    List<TakePart> takeParts;

    @Data
    public static class Filter implements IFilter<User> {
        @ApiModelProperty("过滤姓名")
        String name;


        @Override
        public ISelectQuery<User> apply(ISelectQuery<User> iSelectQuery) {
            return iSelectQuery;
        }
    }

}
