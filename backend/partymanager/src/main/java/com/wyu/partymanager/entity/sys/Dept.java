package com.wyu.partymanager.entity.sys;

import annotation.Column;
import annotation.Id;
import annotation.Table;
import com.wyu.partymanager.entity.JsonEntity;
import core.inerface.IFilter;
import core.inerface.ISelectQuery;
import core.support.IdType;
import lombok.Data;


/**
 * @author Leong
 */
@Data
@Table("pm_dept")
public class Dept implements JsonEntity {

    @Id(value = "id", type = IdType.AUTO)
    long id;

    @Column("name")
    String name;

    @Data
    public static class Filter implements IFilter<Dept> {


        @Override
        public ISelectQuery<Dept> apply(ISelectQuery<Dept> iSelectQuery) {
            return iSelectQuery;
        }
    }

}
