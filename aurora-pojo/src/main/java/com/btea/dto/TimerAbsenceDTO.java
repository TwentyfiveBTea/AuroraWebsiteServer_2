package com.btea.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @Author: TwentyFiveBTea
 * @Date: 2025/01/07 16:42
 * @Description: 打卡请假数据传输对象
 */
@Data
public class TimerAbsenceDTO {
    // 学号
    private String userId;
    // 姓名
    private String name;
    // 请假时间
    @NotBlank(message = "请假时间不能为空")
    private String timerAbsenceTime;
    // 请假理由
    @NotBlank(message = "请假理由不能为空")
    private String timerAbsenceReason;
}
