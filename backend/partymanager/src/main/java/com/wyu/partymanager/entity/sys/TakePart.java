package com.wyu.partymanager.entity.sys;

import com.wyu.partymanager.entity.IEntity;
import lombok.Data;

@Data
public class TakePart implements IEntity {

    long id;

    long userId;
    long activityId;
}
