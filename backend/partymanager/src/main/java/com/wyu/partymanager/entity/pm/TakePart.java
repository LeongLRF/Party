package com.wyu.partymanager.entity.pm;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.wyu.partymanager.entity.IEntity;
import com.wyu.partymanager.entity.JsonEntity;
import com.wyu.partymanager.entity.sys.User;
import com.wyu.partymanager.utils.IFilter;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;
/**
 * @author Leong
 */
@Data
@TableName("pm_take_part")
public class TakePart implements JsonEntity {

    @TableId(value = "id", type = IdType.AUTO)
    long id;

    @ApiModelProperty("参与者Id")
    @TableField("userId")
    long userId;
    @ApiModelProperty("活动Id")
    @TableField("activityId")
    long activityId;

    @ApiModelProperty("参加人员")
    @TableField(exist = false)
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
