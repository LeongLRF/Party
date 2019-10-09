package com.wyu.partymanager.service.pm;

import com.wyu.partymanager.entity.pm.Activity;
import com.wyu.partymanager.mapper.ActivityMapper;
import com.wyu.partymanager.servicedao.ActivityServiceDao;
import com.wyu.partymanager.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivityService implements ActivityServiceDao {
    @Autowired
    private ActivityMapper activityMapper;
    @Override
    public Result<Activity> add_activity(Activity activity) {
        return null;
    }

    @Override
    public Result<Activity> edit_activity(Activity activity) {
        return null;
    }

    @Override
    public Result<?> delete_activity(Activity activity) {
        return null;
    }

    @Override
    public Result<List<Activity>> activity_list(Activity.Filter filter) {
        return null;
    }
}
