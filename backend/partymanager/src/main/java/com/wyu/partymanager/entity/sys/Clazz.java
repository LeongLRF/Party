package com.wyu.partymanager.entity.sys;

import annotation.Column;
import annotation.Id;
import annotation.Table;
import com.wyu.partymanager.entity.JsonEntity;
import core.inerface.IFilter;
import core.inerface.ISelectQuery;
import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * @author Leong
 */
@Data
@ApiModel
@Table("pm_clazz")
public class Clazz implements JsonEntity {

    @Id(value = "id", type = util.IdType.AUTO)
    long id;

    @Column("code")
    String code;

    @Column("name")
    String name;

    @Column("major")
    String major;

    @Column("total")
    int total;

    @Column("teacher")
    String teacher;

    @Data
    public static class Filter implements IFilter<Clazz> {

        @Override
        public ISelectQuery<Clazz> apply(ISelectQuery<Clazz> iSelectQuery) {
            return iSelectQuery;
        }
    }

}
