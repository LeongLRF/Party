package com.wyu.partymanager.entity.pm;

import annotation.Column;
import annotation.Id;
import annotation.Table;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.experimental.Accessors;

import java.sql.Timestamp;

/**
 * @author Leong
 * 消息附带文件
 */
@Table("news_file")
@Data
@Accessors(chain = true)
@ApiModel
public class NewsFile {

    @Id("id")
    long id;

    @Column("url")
    String url;

    @Column("createTime")
    Timestamp createTime;

    @Column("fileId")
    long fileId;

    @Column("downloadTime")
    int downloadTime;
}
