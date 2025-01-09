package com.btea.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: TwentyFiveBTea
 * @Date: 2025/01/09 17:45
 * @Description: 会议请假数据视图对象
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MeetingAbsenceVO {
    // 请假 id
    String id;
    // 请假时间
    String meetingAbsenceTime;
    // 请假理由
    String meetingAbsenceReason;
    // 请假状态
    Integer meetingAbsenceStatus;
}
