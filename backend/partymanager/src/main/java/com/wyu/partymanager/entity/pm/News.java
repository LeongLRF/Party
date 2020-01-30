package com.wyu.partymanager.entity.pm;

import annotation.Column;
import annotation.Id;
import annotation.Table;
import lombok.Data;
import lombok.experimental.Accessors;

import java.sql.Timestamp;
/**
 * @author Leong
 *
 */
@Table("news")
@Data
@Accessors(chain = true)
public class News {

    @Id("id")
    long id;

    @Column("title")
    String title;

    @Column("content")
    String content;

    @Column("createTime")
    Timestamp createTime;

    @Column("operator")
    String operator;


}
