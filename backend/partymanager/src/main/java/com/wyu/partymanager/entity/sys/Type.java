package com.wyu.partymanager.entity.sys;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.wyu.partymanager.entity.JsonEntity;
import com.wyu.partymanager.utils.IFilter;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class Type implements JsonEntity {

    @TableId(value = "id",type = IdType.AUTO)
    long id;

    @TableField("name")
    @ApiModelProperty("类型名字")
    String name;

    public static class Filter extends IFilter<Type>{

        @Override
        public Wrapper<Type> apply() {
            return this.queryWrapper();
        }
    }
}

