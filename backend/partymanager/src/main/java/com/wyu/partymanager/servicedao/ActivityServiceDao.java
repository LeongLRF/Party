package com.wyu.partymanager.servicedao;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wyu.partymanager.entity.dto.AddActivityReq;
import com.wyu.partymanager.entity.pm.Activity;
import com.wyu.partymanager.entity.sys.User;
import com.wyu.partymanager.utils.Result;

import java.util.List;

public interface ActivityServiceDao extends IService<Activity> {

    Result<Activity> add_activity(AddActivityReq activity);
    Result<Activity> edit_activity(Activity activity);
    Result<?> delete_activity(long id);
    Result<List<Activity>> activity_list(Activity.Filter filter, User user);

}
