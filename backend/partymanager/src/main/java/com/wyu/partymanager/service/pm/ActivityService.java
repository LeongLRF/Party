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
import core.DbConnection;
import core.inerface.IDbConnection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ActivityService extends ServiceImpl<ActivityMapper, Activity> implements ActivityServiceDao {
    private final TypeService typeService;
    private final TakePartService takePartService;
    private final IDbConnection db;

    public ActivityService(TypeService typeService, TakePartService takePartService,IDbConnection db) {
        this.typeService = typeService;
        this.takePartService = takePartService;
        this.db = db;
    }

    @Override
    public Result<Activity> addActivity(AddActivityReq activity) {
        if (activity.getIds()==null) {
            return Result.error("请输入参加人员");
        }
        this.db.insert(activity);
        activity.getIds().forEach(id -> {
            TakePart takePart = new TakePart() {{
                setActivityId(activity.getId());
                setUserId(id);
            }};
            db.insert(takePart);
        });
        return Result.ok(activity);
    }

    @Override
    public Result<Activity> editActivity(Activity activity) {
        this.db.update(activity);
        return Result.ok(activity);
    }

    @Override
    public Result<?> deleteActivity(long id) {
        this.db.deleteById(Activity.class,id);
        return Result.ok();
    }

    @Override
    public Result<List<Activity>> activityList(Activity.Filter filter, User user) {
        List<Activity> list;
        if ("admin".equals(user.getRole().getName())) {
            list = db.form(Activity.class).apply(filter).toList();
        } else {
            List<TakePart> takeParts = db.form(TakePart.class).whereEq("userId",user.getId()).toList();
            list = db.form(Activity.class).in("id", takeParts.stream().map(TakePart::getActivityId).count() == 0 ?
                    Collections.singletonList(0) : takeParts.stream().map(TakePart::getActivityId).collect(Collectors.toList())).toList();
        }
        if (!list.isEmpty()){
            new Preloader<>(db, list)
                    .preload_one(Type.class,Activity::getTypeId, Type::getId, "id", Activity::setType);
            new Preloader<>(db, list)
                    .preload_many(TakePart.class,Activity::getId, TakePart::getActivityId, "activityId", Activity::setTakeParts);
//            new Preloader<>(userService, list.stream().flatMap(it -> it.getTakeParts().stream()).collect(Collectors.toList()))
//                    .preload_one(TakePart::getUserId, User::getId, "id", TakePart::setUsers);
        }
        return Result.ok(list);
    }
}
