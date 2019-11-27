package com.wyu.partymanager.entity.sys;

import annotation.Column;
import annotation.Id;
import annotation.Table;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.wyu.partymanager.entity.JsonEntity;
import com.wyu.partymanager.utils.IFilter;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author Leong
 */
@Data
@TableName("pm_dept")
@Table("pm_dept")
public class Dept implements JsonEntity {

    @Id(value = "id", type = util.IdType.AUTO)
    long id;

    @TableField("name")
    @Column("name")
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
