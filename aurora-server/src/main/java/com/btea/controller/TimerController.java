package com.btea.controller;

import com.btea.constant.MessageConstant;
import com.btea.constant.StatusCodeConstant;
import com.btea.dto.TimerAbsenceDTO;
import com.btea.dto.TimerAbsenceManagerDTO;
import com.btea.result.PageResult;
import com.btea.result.R;
import com.btea.service.TimerService;
import com.btea.vo.TimerAbsenceVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

/**
 * @Author: TwentyFiveBTea
 * @Date: 2025/01/07 16:35
 * @Description: 打卡控制层
 */
@RestController
@Slf4j
@Api(tags = "打卡接口")
public class TimerController {
    @Autowired
    TimerService timerService;

    @RequestMapping(method = RequestMethod.POST, path = "/tools/timer/absence")
    @ApiOperation("打卡请假")
    public R askForLeave(@RequestBody @Validated TimerAbsenceDTO timerAbsenceDTO) {
        if (timerService.insertAbsence(timerAbsenceDTO) == 0) {
            return R.error(StatusCodeConstant.SERVER_ERROR, MessageConstant.SERVER_ERROR);
        }
        return R.success(MessageConstant.APPLICATION_SUCCESS);
    }

    @RequestMapping(method = RequestMethod.PUT, path = "/admin/timer/absence/manage/decide")
    @ApiOperation("打卡请假判定")
    public R leaveDecide(@RequestParam String timerAbsenceId, @RequestParam String timerAbsenceStatus) {
        if (timerService.updateTimerAbsenceStatus(timerAbsenceId, timerAbsenceStatus) == 0) {
            return R.error(StatusCodeConstant.SERVER_ERROR, MessageConstant.SERVER_ERROR);
        }
        return R.success(MessageConstant.UPDATE_SUCCESSFULLY);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/tools/timer/myAbsence")
    @ApiOperation("查询个人请假")
    public R selectLeaveStatus(@RequestParam String userId) {
        List<TimerAbsenceVO> timerAbsenceVOS = timerService.selectLeaveStatusByUserId(userId);
        if (timerAbsenceVOS.isEmpty()) {
            return R.success(MessageConstant.QUERY_SUCCESS);
        }
        return R.success(MessageConstant.QUERY_SUCCESS, timerAbsenceVOS);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/admin/timer/absence/manage")
    @ApiOperation("分页查询打卡请假")
    public R<PageResult> queryTimerAbsence(TimerAbsenceManagerDTO timerAbsenceManagerDTO) {
        PageResult pageResult = timerService.pageQuery(timerAbsenceManagerDTO);
        return R.success(pageResult);
    }

}
