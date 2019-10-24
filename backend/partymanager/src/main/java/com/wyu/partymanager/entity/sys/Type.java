package com.wyu.partymanager.entity.sys;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.wyu.partymanager.entity.JsonEntity;
import com.wyu.partymanager.utils.IFilter;
import com.wyu.partymanager.utils.typeHandler.JsonArrTypeHandler;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@TableName("sys_type")
public class Type implements JsonEntity {

    @TableId(value = "id",type = IdType.AUTO)
    long id;

    @TableField("name")
    @ApiModelProperty("类型名字")
    String name;

    @TableField(value = "details",typeHandler = JsonArrTypeHandler.class)
    @ApiModelProperty("主题明细")
    List<Detail> details;

    @Data
    public static class Detail{
        String name;
    }

    @EqualsAndHashCode(callSuper = true)
    @Data
    public static class Filter extends IFilter<Type>{

        @Override
        public Wrapper<Type> apply() {
            return this.queryWrapper();
        }
    }
}

