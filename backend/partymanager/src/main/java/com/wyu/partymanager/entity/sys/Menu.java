package com.wyu.partymanager.entity.sys;

import annotation.Column;
import annotation.Id;
import annotation.Table;
import com.wyu.partymanager.entity.JsonEntity;
import core.inerface.IFilter;
import core.inerface.ISelectQuery;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Leong
 * @date 2019/9/21 20:05
 */
@Data
@Table(value = "sys_menu", cache = true, expireTime = 60 * 60 * 24 * 365)
public class Menu implements JsonEntity {

    @Id(value = "id", type = util.IdType.AUTO)
    long id;
    @ApiModelProperty("菜单名字")
    @Column("name")
    String name;
    @ApiModelProperty("请求路径")
    @Column("url")
    String url;
    @ApiModelProperty("访问权限")
    @Column("permission")
    String permission;

    @ApiModelProperty("父菜单id,0为一级菜单")
    @Column("parentId")
    long parentId;

    @ApiModelProperty("icon")
    @Column("icon")
    String icon;

    @ApiModelProperty("是否启用")
    @Column("valid")
    boolean valid;

    @ApiModelProperty("编号")
    @Column("code")
    String code;

    List<Role> roles;

    Menu parent;

    @ApiModelProperty("权限列表")
    public Collection<Object> permissions() {
        return Arrays.stream(Optional.ofNullable(permission).orElse("0").split(",")).map(Long::valueOf).collect(Collectors.toSet());
    }

    @Data
    public static class Filter implements IFilter<Menu> {
        String name;

        @Override
        public ISelectQuery<Menu> apply(ISelectQuery<Menu> iSelectQuery) {
            return iSelectQuery.orderBy("code desc");
        }
    }
}
