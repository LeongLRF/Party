package com.wyu.partymanager.entity.pm;

import annotation.Column;
import annotation.Id;
import annotation.Table;
import lombok.Data;

@Data
@Table("message")
public class Message {

    @Id("id")
    long id;

    @Column("content")
    String content;

    @Column("senderId")
    long senderId;

}
