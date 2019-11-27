package com.wyu.partymanager.entity.pm;

import annotation.Column;
import annotation.Id;
import annotation.Table;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.wyu.partymanager.entity.JsonEntity;
import com.wyu.partymanager.entity.sys.User;
import com.wyu.partymanager.utils.IFilter;
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

    @EqualsAndHashCode(callSuper = true)
    @Data
    public static class Filter extends IFilter<TakePart> {

        @Override
        public Wrapper<TakePart> apply() {
            return this.queryWrapper();
        }
    }
}
