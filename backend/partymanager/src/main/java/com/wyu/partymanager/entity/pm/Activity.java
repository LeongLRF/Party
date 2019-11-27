package com.wyu.partymanager.entity.pm;

import annotation.Column;
import annotation.Id;
import annotation.Table;
import com.wyu.partymanager.entity.JsonEntity;
import com.wyu.partymanager.entity.sys.Type;
import core.inerface.IFilter;
import core.inerface.ISelectQuery;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.sql.Timestamp;
import java.util.List;

/**
 * @author Leong
 */
@Data
@Table("pm_activity")
public class Activity implements JsonEntity {

    @Id(value = "id", type = util.IdType.AUTO)
    long id;

    @ApiModelProperty("日期")
    @Column("start")
    Timestamp start;

    @ApiModelProperty("大类")
    @Column("typeId")
    long typeId;

    @ApiModelProperty("方式")
    @Column("way")
    String way;

    @ApiModelProperty("活动内容")
    @Column("content")
    String content;

    @ApiModelProperty("地点")
    @Column("place")
    String place;

    @ApiModelProperty("holder")
    @Column("holder")
    String holder;

    @ApiModelProperty("speaker")
    @Column("speaker")
    String speaker;

    @ApiModelProperty("备注")
    @Column("remark")
    String remark;

    @ApiModelProperty("学时")
    @Column("hours")
    int hours;

    @ApiModelProperty("组织单位")
    @Column("deptId")
    long deptId;

    @ApiModelProperty("活动类别")
    Type type;

    List<TakePart> takeParts;

    @Data
    public static class Filter implements IFilter<Activity> {


        @Override
        public ISelectQuery<Activity> apply(ISelectQuery<Activity> iSelectQuery) {
            return iSelectQuery;
        }
    }
}
