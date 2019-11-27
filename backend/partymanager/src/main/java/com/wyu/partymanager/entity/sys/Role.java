package com.wyu.partymanager.entity.sys;

import annotation.Column;
import annotation.Id;
import annotation.Table;
import com.wyu.partymanager.entity.JsonEntity;
import core.inerface.IFilter;
import core.inerface.ISelectQuery;
import lombok.Data;

/**
 * @author Leong
 * @date 2019/9/21 13:23
 */
@Data
@Table(value = "sys_role", cache = true, expireTime = 60 * 60 * 24 * 365)
public class Role implements JsonEntity {

    @Id(value = "id", type = util.IdType.AUTO)
    long id;
    @Column("name")
    String name;
    @Column("permission")
    String permission;
    @Column("valid")
    boolean valid;

    @Data
    public static class Filter implements IFilter<Role> {

        @Override
        public ISelectQuery<Role> apply(ISelectQuery<Role> iSelectQuery) {
            return iSelectQuery;
        }
    }

}
