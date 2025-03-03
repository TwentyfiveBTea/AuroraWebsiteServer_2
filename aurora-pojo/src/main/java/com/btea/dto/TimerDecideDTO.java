package com.btea.dto;

import lombok.Data;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author: TwentyFiveBTea
 * @Date: 2025/3/3 14:49
 * @Description: 打卡请假理由判定数据传输对象
 */
@Data
public class TimerDecideDTO {
    // 打卡理由 ID
    String timerAbsenceId;

    // 打卡理由状态
    String timerAbsenceStatus;
}
