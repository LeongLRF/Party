package com.wyu.partymanager.entity;

import java.sql.Timestamp;

public interface TimestampEntity {
    Timestamp getInsertedAt();
    void setInsertedAt(Timestamp value);

    Timestamp getUpdatedAt();
    void setUpdatedAt(Timestamp value);
}
