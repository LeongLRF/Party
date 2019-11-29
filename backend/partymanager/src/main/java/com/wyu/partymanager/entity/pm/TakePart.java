package com.wyu.partymanager.entity.pm;

import annotation.Column;
import annotation.Id;
import annotation.Table;
import com.wyu.partymanager.entity.JsonEntity;
import com.wyu.partymanager.entity.sys.User;
import core.inerface.IFilter;
import core.inerface.ISelectQuery;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;


/**
 * @author Leong
 */
@Data
@Table("pm_take_part")
public class TakePart implements JsonEntity {

    @Id("id")
    long id;

    @ApiModelProperty("参与者Id")
    @Column("userId")
    long userId;
    @ApiModelProperty("活动Id")
    @Column("activityId")
    long activityId;

    @ApiModelProperty("参加人员")
    User users;

    @Data
    public static class Filter implements IFilter<TakePart> {

        @Override
        public ISelectQuery<TakePart> apply(ISelectQuery<TakePart> iSelectQuery) {
            return iSelectQuery;
        }
    }
}
