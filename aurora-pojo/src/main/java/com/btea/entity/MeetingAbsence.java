package com.btea.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @Author: TwentyFiveBTea
 * @Date: 2024/11/28 17:56
 * @Description: 会议请假实体类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MeetingAbsence implements Serializable {
    // 请假 id
    private String id;

    // 学号
    private String userId;

    // 姓名
    private String name;

    // 请假时间
    private String meetingAbsenceTime;

    // 请假理由
    private String meetingAbsenceReason;

    // 请假状态
    private Integer meetingAbsenceStatus;

    // 创建时间
    private LocalDateTime createTime;
}
