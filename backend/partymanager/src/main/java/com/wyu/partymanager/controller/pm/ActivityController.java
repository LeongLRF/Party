package com.wyu.partymanager.controller.pm;

import com.wyu.partymanager.controller.BaseController;
import com.wyu.partymanager.entity.dto.AddActivityReq;
import com.wyu.partymanager.entity.pm.Activity;
import com.wyu.partymanager.service.pm.ActivityService;
import com.wyu.partymanager.utils.Result;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/**
 * @author Leong
 */
@RestController
@RequestMapping("/activity")
public class ActivityController extends BaseController {

    private final ActivityService activityService;

    public ActivityController(ActivityService activityService) {
        this.activityService = activityService;
    }

    @ApiOperation("录入【活动】")
    @PostMapping("/add_activity")
    public Result<Activity> addActivity(@RequestBody AddActivityReq req){
        return activityService.addActivity(req);
    }

    @ApiOperation("获取台账列表")
    @GetMapping("/activity_list")
    public Result<List<Activity>> activityList(Activity.Filter filter){
        return activityService.activityList(filter,current_user());
    }

    @ApiOperation("删除活动")
    @PostMapping("/delete_activity")
    public Result<?> deleteActivity(long activityId){
        return activityService.deleteActivity(activityId);
    }
}
