package com.btea.mapper;

import com.btea.annotation.AutoFill;
import com.btea.dto.TimerAbsenceManagerDTO;
import com.btea.entity.TimerAbsence;
import com.btea.enumeration.OperationType;
import com.btea.vo.TimerAbsenceManagerVO;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: TwentyFiveBTea
 * @Date: 2025/01/07 16:36
 * @Description: 打卡访问层
 */
@Mapper
public interface TimerMapper {
    /**
     * 提交打卡请假申请
     *
     * @param timerAbsence
     * @return
     */
    @AutoFill(OperationType.INSERT)
    int insertAbsence(TimerAbsence timerAbsence);

    /**
     * 更新打卡请假状态
     *
     * @param timerAbsenceId
     * @param timerAbsenceStatus
     * @return
     */
    int updateTimerAbsenceStatus(@Param("timerAbsenceId") String timerAbsenceId, @Param("timerAbsenceStatus") String timerAbsenceStatus);

    /**
     * 查询个人请假
     *
     * @param userId
     * @return
     */
    List<TimerAbsence> selectLeaseStatusByUserId(String userId);

    /**
     * 分页查询打卡请假
     *
     * @param timerAbsenceManagerDTO
     * @return
     */
    Page<TimerAbsenceManagerVO> pageQuery(TimerAbsenceManagerDTO timerAbsenceManagerDTO);
}
