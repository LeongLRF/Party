package com.wyu.partymanager.entity.sys;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.wyu.partymanager.entity.IEntity;
import com.wyu.partymanager.entity.JsonEntity;
import com.wyu.partymanager.utils.IFilter;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author Leong
 * @date 2019/9/21 20:05
 */
@Data
@TableName("sys_menu")
public class Menu implements JsonEntity {

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

    @ApiModelProperty("icon")
    @TableField("icon")
    String icon;

    @ApiModelProperty("是否启用")
    @TableField("valid")
    boolean valid;

    @ApiModelProperty("编号")
    @TableField("code")
    String code;

    @TableField(exist = false)
    List<Role> roles;

    @TableField(exist = false)
    Menu parent;

    @ApiModelProperty("权限列表")
    public Set<Long> permissions(){
            return Arrays.stream(Optional.ofNullable(permission).orElse("0").split(",")).map(Long::valueOf).collect(Collectors.toSet());
    }

    @EqualsAndHashCode(callSuper = true)
    @Data
    public static class Filter extends IFilter<Menu> {
        String name;
        @Override
        public Wrapper<Menu> apply() {
            return this.queryWrapper().orderByAsc("code");
        }
    }
}
