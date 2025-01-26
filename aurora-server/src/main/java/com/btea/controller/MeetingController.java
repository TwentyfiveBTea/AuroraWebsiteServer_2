package com.btea.controller;

import com.btea.constant.MessageConstant;
import com.btea.constant.StatusCodeConstant;
import com.btea.dto.MeetingAbsenceDTO;
import com.btea.dto.MeetingAbsenceManegerDTO;
import com.btea.result.PageResult;
import com.btea.result.R;
import com.btea.service.MeetingService;
import com.btea.vo.MeetingAbsenceVO;
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
 * @Date: 2025/01/09 15:35
 * @Description: 会议控制层
 */
@RestController
@Slf4j
@Api(tags = "会议接口")
public class MeetingController {
    @Autowired
    MeetingService meetingService;

    @RequestMapping(method = RequestMethod.POST, path = "/tools/meeting/absence")
    @ApiOperation("会议请假")
    public R askForLeave(@RequestBody @Validated MeetingAbsenceDTO meetingAbsenceDTO) {
        log.info("收到请假数据：" + meetingAbsenceDTO);
        if (meetingService.insertAbsence(meetingAbsenceDTO) == 0) {
            return R.error(StatusCodeConstant.SERVER_ERROR, MessageConstant.SERVER_ERROR);
        }
        return R.success(MessageConstant.APPLICATION_SUCCESS);
    }

    @RequestMapping(method = RequestMethod.PUT, path = "/admin/meeting/absence/manage/decide")
    @ApiOperation("会议请假判定")
    public R leaveDecide(@RequestParam String meetingAbsenceId, @RequestParam String meetingAbsenceStatus) {
        log.info("将id为：" + meetingAbsenceId + "的状态改为：" + meetingAbsenceStatus);
        if (meetingService.updateMeetingAbsenceStatus(meetingAbsenceId, meetingAbsenceStatus) == 0) {
            return R.error(StatusCodeConstant.SERVER_ERROR, MessageConstant.SERVER_ERROR);
        }
        return R.success(MessageConstant.UPDATE_SUCCESSFULLY);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/tools/meeting/myAbsence")
    @ApiOperation("查询个人请假")
    public R selectLeaveStatus(@RequestParam String userId) {
        log.info("查询学号为：" + userId + "的会议请假记录");
        List<MeetingAbsenceVO> meetingAbsenceVOS = meetingService.selectLeaveStatusByUserId(userId);
        if (meetingAbsenceVOS.isEmpty()) {
            return R.success(MessageConstant.QUERY_SUCCESS);
        }
        return R.success(MessageConstant.QUERY_SUCCESS, meetingAbsenceVOS);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/admin/meeting/absence/manage")
    @ApiOperation("分页查询会议请假记录")
    public R queryMeetingAbsence(MeetingAbsenceManegerDTO meetingAbsenceManegerDTO) {
        log.info("分页要求数据为：" + meetingAbsenceManegerDTO);
        PageResult pageResult = meetingService.pageQuery(meetingAbsenceManegerDTO);
        return R.success(pageResult);
    }

}
