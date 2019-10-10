package com.wyu.partymanager.entity.sys;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.wyu.partymanager.entity.IEntity;
import com.wyu.partymanager.entity.JsonEntity;
import com.wyu.partymanager.utils.IFilter;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@TableName("pm_dept")
public class Dept implements JsonEntity {

    @TableId(value = "id",type = IdType.AUTO)
    long id;

    @ApiModelProperty("部门名字")
    @TableField("name")
    String name;

    @EqualsAndHashCode(callSuper = true)
    @Data
    public static class Filter extends IFilter<Dept> {

        @Override
        public Wrapper<Dept> apply() {
            return this.queryWrapper();
        }
    }

}
