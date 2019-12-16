package com.wyu.partymanager.entity.sys;

import annotation.Column;
import annotation.Id;
import annotation.Table;
import core.support.IdType;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;

/**
 * @author Leong
 */
@Data
@Table("sys_token")
@ApiModel
public class Token implements Serializable {

    @Id(value = "token", idType = IdType.UNDEFINE)
    String token;

    @Column("userId")
    long userId;
}
