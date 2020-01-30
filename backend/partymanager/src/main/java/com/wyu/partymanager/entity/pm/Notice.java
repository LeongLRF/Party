package com.wyu.partymanager.entity.pm;

import annotation.Column;
import annotation.Id;
import annotation.Table;
import com.wyu.partymanager.entity.TimestampEntity;
import core.support.IdType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.sql.Timestamp;

/**
 * @author Leong
 * @date 2020/1/30 23:10
 */
@Table("notice")
@ApiModel
@Data
public class Notice implements TimestampEntity {

    @Id(value = "id", idType = IdType.AUTO)
    long id;

    @Column("send_person")
    long sendPerson;

    @Column("accept_person")
    long acceptPerson;

    @Column("content")
    String content;

    @Column("inserted_at")
    Timestamp insertedAt;

    @Column("updated_at")
    Timestamp updatedAt;

    @Column("status")
    int status;


}
