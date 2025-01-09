package com.btea.mapper;

import com.btea.annotation.AutoFill;
import com.btea.dto.MeetingAbsenceManegerDTO;
import com.btea.entity.MeetingAbsence;
import com.btea.enumeration.OperationType;
import com.btea.vo.MeetingAbsenceVO;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: TwentyFiveBTea
 * @Date: 2025/01/09 15:38
 * @Description: 打卡访问层
 */
@Mapper
public interface MeetingMapper {
    /**
     * 提交打卡请假申请
     *
     * @param meetingAbsence
     * @return
     */
    @AutoFill(OperationType.INSERT)
    int insertAbsence(MeetingAbsence meetingAbsence);

    /**
     * 更新打卡请假状态
     *
     * @param meetingAbsenceId
     * @param meetingAbsenceStatus
     * @return
     */
    int updateMeetingAbsenceStatus(@Param("meetingAbsenceId") String meetingAbsenceId, @Param("meetingAbsenceStatus") String meetingAbsenceStatus);

    /**
     * 查询个人请假
     *
     * @param userId
     * @return
     */
    List<MeetingAbsence> selectLeaseStatusByUserId(String userId);

    /**
     * 分页查询打卡请假
     *
     * @param meetingAbsenceManegerDTO
     * @return
     */
    Page<MeetingAbsenceVO> pageQuery(MeetingAbsenceManegerDTO meetingAbsenceManegerDTO);
}
