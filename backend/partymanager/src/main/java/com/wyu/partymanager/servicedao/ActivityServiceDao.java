package com.wyu.partymanager.servicedao;

import com.wyu.partymanager.entity.dto.AddActivityReq;
import com.wyu.partymanager.entity.pm.Activity;
import com.wyu.partymanager.entity.sys.User;
import com.wyu.partymanager.utils.Result;

import java.util.List;

public interface ActivityServiceDao {

    Result<Activity> addActivity(AddActivityReq activity);
    Result<Activity> editActivity(Activity activity);
    Result<?> deleteActivity(long id);
    Result<List<Activity>> activityList(Activity.Filter filter, User user);

}
