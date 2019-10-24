package com.wyu.partymanager.controller.pm;

import com.wyu.partymanager.entity.dto.AddActivityReq;
import com.wyu.partymanager.entity.pm.Activity;
import com.wyu.partymanager.service.pm.ActivityService;
import com.wyu.partymanager.utils.Result;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/activity")
public class ActivityController {

    private final ActivityService activityService;

    public ActivityController(ActivityService activityService) {
        this.activityService = activityService;
    }

    @ApiOperation("录入【活动】")
    @PostMapping("/add_activity")
    public Result<Activity> add_activity(@RequestBody AddActivityReq req){
        return activityService.add_activity(req);
    }

    @ApiOperation("获取台账列表")
    @GetMapping("/activity_list")
    public Result<List<Activity>> activity_list(Activity.Filter filter){
        return Result.ok(activityService.list(filter.apply()));
    }
}
