package com.wyu.partymanager.entity.sys;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.wyu.partymanager.utils.IFilter;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author Leong
 * @date 2019/9/21 20:05
 */
@Data
@TableName("sys_menu")
public class Menu implements Serializable {

    @TableId(value = "id",type = IdType.AUTO)
    long id;
    @ApiModelProperty("菜单名字")
    @TableField("name")
    String name;
    @ApiModelProperty("请求路径")
    @TableField("url")
    String url;
    @ApiModelProperty("访问权限")
    @TableField("permission")
    String permission;

    @ApiModelProperty("父菜单id,0为一级菜单")
    @TableField("parentId")
    long parentId;

    @Data
    public static class Filter implements IFilter<Menu>{
        @JsonIgnore
        QueryWrapper<Menu> queryWrapper = new QueryWrapper<>();

        @Override
        public Wrapper<Menu> apply() {
            return this.queryWrapper;
        }
    }
}
