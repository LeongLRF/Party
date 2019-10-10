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
    private final ActivityMapper activityMapper;

    public ActivityService(ActivityMapper activityMapper) {
        this.activityMapper = activityMapper;
    }

    @Override
    public Result<Activity> add_activity(Activity activity) {
        activityMapper.insert(activity);
        return Result.ok(activity);
    }

    @Override
    public Result<Activity> edit_activity(Activity activity) {
        activityMapper.update(activity,null);
        return Result.ok(activity);
    }

    @Override
    public Result<?> delete_activity(Activity activity) {
        activityMapper.deleteById(activity.getId());
        return Result.ok();
    }

    @Override
    public Result<List<Activity>> activity_list(Activity.Filter filter) {
        return Result.ok(activityMapper.selectList(filter.apply()));
    }
}
