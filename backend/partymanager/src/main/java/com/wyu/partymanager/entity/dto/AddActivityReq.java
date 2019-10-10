package com.wyu.partymanager.entity.dto;

import com.wyu.partymanager.entity.pm.Activity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class AddActivityReq extends Activity {

    @ApiModelProperty("参加人员的Id")
    List<Long> ids;
}
