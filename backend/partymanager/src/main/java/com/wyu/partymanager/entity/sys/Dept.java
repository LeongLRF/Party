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
@TableName("pm_dept")
public class Dept implements IEntity {

    @TableId(value = "id",type = IdType.AUTO)
    long id;

    @ApiModelProperty("部门名字")
    @TableField("name")
    String name;

    @Data
    public static class Filter implements IFilter<Dept>{
        @JsonIgnore
        QueryWrapper<Dept> queryWrapper = new QueryWrapper<>();

        @Override
        public Wrapper<Dept> apply() {
            return this.queryWrapper;
        }
    }

}
