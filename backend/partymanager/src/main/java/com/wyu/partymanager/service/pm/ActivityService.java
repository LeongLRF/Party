package com.wyu.partymanager.service.pm;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wyu.partymanager.entity.dto.AddActivityReq;
import com.wyu.partymanager.entity.pm.Activity;
import com.wyu.partymanager.entity.pm.TakePart;
import com.wyu.partymanager.entity.sys.Type;
import com.wyu.partymanager.mapper.ActivityMapper;
import com.wyu.partymanager.mapper.TakePartMapper;
import com.wyu.partymanager.service.sys.TypeService;
import com.wyu.partymanager.servicedao.ActivityServiceDao;
import com.wyu.partymanager.utils.Preloader;
import com.wyu.partymanager.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivityService extends ServiceImpl<ActivityMapper,Activity> implements ActivityServiceDao {
    private final ActivityMapper activityMapper;
    private final TakePartMapper takePartMapper;
    private final TypeService typeService;

    public ActivityService(ActivityMapper activityMapper, TakePartMapper takePartMapper, TypeService typeService) {
        this.activityMapper = activityMapper;
        this.takePartMapper = takePartMapper;
        this.typeService = typeService;
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
        List<Activity> list = activityMapper.selectList(filter.apply());
        new Preloader<>(typeService,list)
                .preload_one(Activity::getTypeId, Type::getId,"id",Activity::setType);
        return Result.ok(list);
    }
}
