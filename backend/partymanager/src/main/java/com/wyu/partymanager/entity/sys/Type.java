package com.wyu.partymanager.entity.sys;

import annotation.Column;
import annotation.Id;
import annotation.Table;

import com.wyu.partymanager.entity.JsonEntity;

import core.inerface.IFilter;
import core.inerface.ISelectQuery;
import core.support.IdType;
import core.support.JdbcType;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


import java.util.List;

/**
 * @author Leong
 */
@Data
@Table("sys_type")
public class Type {

    @Id(value = "id", type = IdType.AUTO)
    long id;

    @ApiModelProperty("类型名字")
    @Column("name")
    String name;

    @ApiModelProperty("主题明细")
    @Column(value = "details", jdbcType = JdbcType.JSON)
    List<Detail> details;

    @Data
    public static class Detail {
        String name;
    }

    @Data
    public static class Filter implements IFilter<Type> {

        @Override
        public ISelectQuery<Type> apply(ISelectQuery<Type> iSelectQuery) {
            return iSelectQuery;
        }
    }
}

