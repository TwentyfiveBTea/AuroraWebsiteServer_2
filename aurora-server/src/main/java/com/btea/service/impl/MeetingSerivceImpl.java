package com.btea.service.impl;

import com.btea.constant.ApplyStatusConstant;
import com.btea.dto.MeetingAbsenceDTO;
import com.btea.dto.MeetingAbsenceManegerDTO;
import com.btea.entity.MeetingAbsence;
import com.btea.mapper.MeetingMapper;
import com.btea.result.PageResult;
import com.btea.service.MeetingService;
import com.btea.vo.MeetingAbsenceVO;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * @Author: TwentyFiveBTea
 * @Date: 2025/01/09 15:37
 * @Description: 会议服务层接口实现类
 */
@Service
public class MeetingSerivceImpl implements MeetingService {
    @Autowired
    MeetingMapper meetingMapper;

    /**
     * 提交打卡请假申请
     *
     * @param meetingAbsenceDTO
     * @return
     */
    @Override
    public int insertAbsence(MeetingAbsenceDTO meetingAbsenceDTO) {
        MeetingAbsence meetingAbsence = new MeetingAbsence().builder()
                .id(UUID.randomUUID().toString())
                .userId(meetingAbsenceDTO.getUserId())
                .name(meetingAbsenceDTO.getName())
                .meetingAbsenceTime(meetingAbsenceDTO.getMeetingAbsenceTime())
                .meetingAbsenceReason(meetingAbsenceDTO.getMeetingAbsenceReason())
                .meetingAbsenceStatus(ApplyStatusConstant.ORIGINAL)
                .build();

        return meetingMapper.insertAbsence(meetingAbsence);
    }

    /**
     * 更新打卡请假状态
     *
     * @param meetingAbsenceId
     * @param meetingAbsenceStatus
     * @return
     */
    @Override
    public int updateMeetingAbsenceStatus(String meetingAbsenceId, String meetingAbsenceStatus) {
        return meetingMapper.updateMeetingAbsenceStatus(meetingAbsenceId, meetingAbsenceStatus);
    }

    /**
     * 查询个人请假
     *
     * @param userId
     * @return
     */
    @Override
    public List<MeetingAbsenceVO> selectLeaveStatusByUserId(String userId) {
        List<MeetingAbsence> meetingAbsences = meetingMapper.selectLeaseStatusByUserId(userId);
        if (meetingAbsences == null || meetingAbsences.isEmpty()) {
            return Collections.emptyList();
        }
        List<MeetingAbsenceVO> meetingAbsenceVOS = meetingAbsences.stream()
                .map(meetingAbsence -> new MeetingAbsenceVO().builder()
                        .id(meetingAbsence.getId())
                        .name(meetingAbsence.getName())
                        .meetingAbsenceTime(meetingAbsence.getMeetingAbsenceTime())
                        .meetingAbsenceReason(meetingAbsence.getMeetingAbsenceReason())
                        .meetingAbsenceStatus(meetingAbsence.getMeetingAbsenceStatus())
                        .build())
                .collect(Collectors.toList());

        return meetingAbsenceVOS;
    }

    /**
     * 分页查询会议请假
     *
     * @param meetingAbsenceManegerDTO
     * @return
     */
    @Override
    public PageResult pageQuery(MeetingAbsenceManegerDTO meetingAbsenceManegerDTO) {
        PageHelper.startPage(meetingAbsenceManegerDTO.getPage(), meetingAbsenceManegerDTO.getPageSize());
        Page<MeetingAbsenceVO> page = meetingMapper.pageQuery(meetingAbsenceManegerDTO);
        return new PageResult(page.getTotal(), page.getResult());
    }
}
