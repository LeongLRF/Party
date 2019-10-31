package com.wyu.partymanager.service.pm;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wyu.partymanager.entity.dto.AddActivityReq;
import com.wyu.partymanager.entity.pm.Activity;
import com.wyu.partymanager.entity.pm.TakePart;
import com.wyu.partymanager.entity.sys.Type;
import com.wyu.partymanager.entity.sys.User;
import com.wyu.partymanager.mapper.ActivityMapper;
import com.wyu.partymanager.mapper.TakePartMapper;
import com.wyu.partymanager.service.sys.TypeService;
import com.wyu.partymanager.service.sys.UserService;
import com.wyu.partymanager.servicedao.ActivityServiceDao;
import com.wyu.partymanager.utils.Preloader;
import com.wyu.partymanager.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ActivityService extends ServiceImpl<ActivityMapper,Activity> implements ActivityServiceDao {
    private final TypeService typeService;
    private final TakePartService takePartService;
    private final UserService userService;

    public ActivityService( TypeService typeService, TakePartService takePartService, UserService userService) {
        this.typeService = typeService;
        this.takePartService = takePartService;
        this.userService = userService;
    }

    @Override
    public Result<Activity> add_activity(AddActivityReq activity) {
        this.baseMapper.insert(activity);
        activity.getIds().forEach(id -> {
            TakePart takePart = new TakePart() {{
                setActivityId(activity.getId());
                setUserId(id);
            }};
            takePartService.save(takePart);
        });
        return Result.ok(activity);
    }

    @Override
    public Result<Activity> edit_activity(Activity activity) {
        this.baseMapper.update(activity, null);
        return Result.ok(activity);
    }

    @Override
    public Result<?> delete_activity(long id) {
        this.baseMapper.deleteById(id);
        return Result.ok();
    }

    @Override
    public Result<List<Activity>> activity_list(Activity.Filter filter,User user) {
        List<Activity> list;
        if (user.getRole().getName().equals("admin")){
            list = this.baseMapper.selectList(filter.apply());
        } else {
            List<TakePart> takeParts = takePartService.lambdaQuery().eq(TakePart::getUserId,user.getId()).list();
            list = this.lambdaQuery().in(Activity::getId,takeParts.stream().map(TakePart::getActivityId).collect(Collectors.toList())).list();
        }
        new Preloader<>(typeService,list)
                .preload_one(Activity::getTypeId, Type::getId,"id",Activity::setType);
        new Preloader<>(takePartService,list)
                .preload_many(Activity::getId,TakePart::getActivityId,"activityId",Activity::setTakeParts);
        new Preloader<>(userService,list.stream().flatMap(it -> it.getTakeParts().stream()).collect(Collectors.toList()))
                .preload_one(TakePart::getUserId, User::getId,"id",TakePart::setUsers);
        return Result.ok(list);
    }
}
