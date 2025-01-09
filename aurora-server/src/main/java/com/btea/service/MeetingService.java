package com.btea.service;

import com.btea.dto.MeetingAbsenceDTO;
import com.btea.dto.MeetingAbsenceManegerDTO;
import com.btea.dto.TimerAbsenceManagerDTO;
import com.btea.result.PageResult;
import com.btea.vo.MeetingAbsenceVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @Author: TwentyFiveBTea
 * @Date: 2025/01/09 15:37
 * @Description: 会议服务层接口
 */
public interface MeetingService {
    /**
     * 提交打卡请假申请
     *
     * @param meetingAbsenceDTO
     * @return
     */
    int insertAbsence(MeetingAbsenceDTO meetingAbsenceDTO);

    /**
     * 更新打卡请假状态
     *
     * @param meetingAbsenceId
     * @param meetingAbsenceStatus
     * @return
     */
    int updateMeetingAbsenceStatus(String meetingAbsenceId, String meetingAbsenceStatus);

    /**
     * 查询个人请假
     *
     * @param userId
     * @return
     */
    List<MeetingAbsenceVO> selectLeaveStatusByUserId(String userId);

    /**
     * 分页查询会议请假
     *
     * @param meetingAbsenceManegerDTO
     * @return
     */
    PageResult pageQuery(MeetingAbsenceManegerDTO meetingAbsenceManegerDTO);
}
