package com.btea.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: TwentyFiveBTea
 * @Date: 2025/01/08 11:37
 * @Description: 打卡请假数据视图对象
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TimerAbsenceVO {
    // 请假 id
    String id;
    // 请假时间
    String timerAbsenceTime;
    // 请假理由
    String timerAbsenceReason;
    // 请假状态
    Integer timerAbsenceStatus;
}