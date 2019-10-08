package com.wyu.partymanager.entity.sys;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.wyu.partymanager.entity.IEntity;
import com.wyu.partymanager.utils.IFilter;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@TableName("pm_takepart")
public class TakePart implements IEntity {

    @TableId(value = "id", type = IdType.AUTO)
    long id;

    @ApiModelProperty("参与者Id")
    @TableField("userId")
    long userId;
    @ApiModelProperty("活动Id")
    @TableField("activityId")
    long activityId;

    @EqualsAndHashCode(callSuper = true)
    @Data
    public static class Filter extends IFilter<TakePart> {

        @Override
        public Wrapper<TakePart> apply() {
            return this.getQueryWrapper();
        }
    }
}
