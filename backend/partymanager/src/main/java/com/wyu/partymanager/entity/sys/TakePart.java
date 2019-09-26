package com.wyu.partymanager.entity.sys;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.wyu.partymanager.entity.IEntity;
import com.wyu.partymanager.utils.IFilter;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

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

    @Data
    public static class Filter implements IFilter<TakePart>{
        @JsonIgnore
        QueryWrapper<TakePart> queryWrapper = new QueryWrapper<>();

        @Override
        public Wrapper<TakePart> apply() {
            return this.queryWrapper;
        }
    }
}
