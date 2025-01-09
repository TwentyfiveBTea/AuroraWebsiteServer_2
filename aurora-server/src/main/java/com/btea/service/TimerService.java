package com.btea.service;

import com.btea.dto.TimerAbsenceDTO;
import com.btea.dto.TimerAbsenceManagerDTO;
import com.btea.result.PageResult;
import com.btea.vo.TimerAbsenceVO;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author: TwentyFiveBTea
 * @Date: 2025/01/07 16:35
 * @Description: 打卡服务层接口
 */
public interface TimerService {
    /**
     * 提交打卡请假申请
     *
     * @param timerAbsenceDTO
     * @return
     */
    int insertAbsence(TimerAbsenceDTO timerAbsenceDTO);

    /**
     * 更新打卡请假状态
     *
     * @param timerAbsenceId
     * @param timerAbsenceStatus
     * @return
     */
    int updateTimerAbsenceStatus(String timerAbsenceId, String timerAbsenceStatus);

    /**
     * 查询个人请假
     *
     * @param userId
     * @return
     */
    TimerAbsenceVO selectLeaveStatusByUserId(String userId);

    /**
     * 分页查询打卡请假
     *
     * @param timerAbsenceManagerDTO
     * @return
     */
    PageResult pageQuery(TimerAbsenceManagerDTO timerAbsenceManagerDTO);
}
