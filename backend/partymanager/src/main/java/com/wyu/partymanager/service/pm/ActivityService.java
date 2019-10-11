package com.wyu.partymanager.service.pm;

import com.wyu.partymanager.entity.dto.AddActivityReq;
import com.wyu.partymanager.entity.pm.Activity;
import com.wyu.partymanager.entity.pm.TakePart;
import com.wyu.partymanager.mapper.ActivityMapper;
import com.wyu.partymanager.mapper.TakePartMapper;
import com.wyu.partymanager.servicedao.ActivityServiceDao;
import com.wyu.partymanager.utils.Result;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivityService implements ActivityServiceDao {
    private final ActivityMapper activityMapper;
    private final TakePartMapper takePartMapper;

    public ActivityService(ActivityMapper activityMapper, TakePartMapper takePartMapper) {
        this.activityMapper = activityMapper;
        this.takePartMapper = takePartMapper;
    }

    @Override
    public Result<Activity> add_activity(AddActivityReq activity) {
        activityMapper.insert(activity);
        activity.getIds().forEach(id -> {
            TakePart takePart = new TakePart() {{
                setActivityId(activity.getId());
                setUserId(id);
            }};
            takePartMapper.insert(takePart);
        });
        return Result.ok(activity);
    }

    @Override
    public Result<Activity> edit_activity(Activity activity) {
        activityMapper.update(activity, null);
        return Result.ok(activity);
    }

    @Override
    public Result<?> delete_activity(long id) {
        activityMapper.deleteById(id);
        return Result.ok();
    }

    @Override
    public Result<List<Activity>> activity_list(Activity.Filter filter) {
        return Result.ok(activityMapper.selectList(filter.apply()));
    }
}
