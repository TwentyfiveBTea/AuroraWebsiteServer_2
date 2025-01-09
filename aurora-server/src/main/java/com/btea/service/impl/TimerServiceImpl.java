package com.btea.service.impl;

import com.btea.constant.ApplyStatusConstant;
import com.btea.dto.TimerAbsenceDTO;
import com.btea.dto.TimerAbsenceManagerDTO;
import com.btea.entity.TimerAbsence;
import com.btea.mapper.TimerMapper;
import com.btea.result.PageResult;
import com.btea.service.TimerService;
import com.btea.vo.TimerAbsenceManagerVO;
import com.btea.vo.TimerAbsenceVO;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * @Author: TwentyFiveBTea
 * @Date: 2025/01/07 16:35
 * @Description: 打卡服务层接口实现类
 */
@Service
public class TimerServiceImpl implements TimerService {
    @Autowired
    TimerMapper timerMapper;

    /**
     * 提交打卡请假申请
     *
     * @param timerAbsenceDTO
     * @return
     */
    @Override
    public int insertAbsence(TimerAbsenceDTO timerAbsenceDTO) {
        TimerAbsence timerAbsence = new TimerAbsence().builder()
                .id(UUID.randomUUID().toString())
                .userId(timerAbsenceDTO.getUserId())
                .name(timerAbsenceDTO.getName())
                .timerAbsenceTime(timerAbsenceDTO.getTimerAbsenceTime())
                .timerAbsenceReason(timerAbsenceDTO.getTimerAbsenceReason())
                .timerAbsenceStatus(ApplyStatusConstant.ORIGINAL)
                .build();

        return timerMapper.insertAbsence(timerAbsence);
    }

    /**
     * 更新打卡请假状态
     *
     * @param timerAbsenceId
     * @param timerAbsenceStatus
     * @return
     */
    @Override
    public int updateTimerAbsenceStatus(String timerAbsenceId, String timerAbsenceStatus) {
        return timerMapper.updateTimerAbsenceStatus(timerAbsenceId, timerAbsenceStatus);
    }

    /**
     * 查询个人请假
     *
     * @param userId
     * @return
     */
    @Override
    public List<TimerAbsenceVO> selectLeaveStatusByUserId(String userId) {
        List<TimerAbsence> timerAbsences = timerMapper.selectLeaseStatusByUserId(userId);
        if (timerAbsences == null || timerAbsences.isEmpty()) {
            return Collections.emptyList();
        }
        List<TimerAbsenceVO> timerAbsenceVOS = timerAbsences.stream()
                .map(timerAbsence -> new TimerAbsenceVO().builder()
                        .id(timerAbsence.getId())
                        .timerAbsenceTime(timerAbsence.getTimerAbsenceTime())
                        .timerAbsenceReason(timerAbsence.getTimerAbsenceReason())
                        .timerAbsenceStatus(timerAbsence.getTimerAbsenceStatus())
                        .build())
                .collect(Collectors.toList());

        return timerAbsenceVOS;
    }

    /**
     * 分页查询打卡请假
     *
     * @param timerAbsenceManagerDTO
     * @return
     */
    @Override
    public PageResult pageQuery(TimerAbsenceManagerDTO timerAbsenceManagerDTO) {
        PageHelper.startPage(timerAbsenceManagerDTO.getPage(), timerAbsenceManagerDTO.getPageSize());
        Page<TimerAbsenceManagerVO> page = timerMapper.pageQuery(timerAbsenceManagerDTO);
        return new PageResult(page.getTotal(), page.getResult());
    }
}
