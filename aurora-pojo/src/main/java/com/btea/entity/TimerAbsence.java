package com.btea.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @Author: TwentyFiveBTea
 * @Date: 2024/11/28 17:59
 * @Description: 打卡请假实体类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TimerAbsence implements Serializable {
    // 请假 id
    private String id;

    // 学号
    private String userId;

    // 姓名
    private String name;

    // 请假时间
    private String timerAbsenceTime;

    // 请假理由
    private String timerAbsenceReason;

    // 请假状态
    private Integer timerAbsenceStatus;

    // 创建时间
    private LocalDateTime createTime;
}
