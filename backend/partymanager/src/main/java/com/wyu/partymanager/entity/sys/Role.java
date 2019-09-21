package com.wyu.partymanager.entity.sys;

import com.wyu.partymanager.entity.TimestampEntity;
import lombok.Data;

import java.sql.Timestamp;

/**
 * @author Leong
 * @date 2019/9/21 13:23
 */
@Data
public class Role implements TimestampEntity {

    String name;
    Timestamp insertedAt;
    Timestamp updatedAt;
    String permission;
}
