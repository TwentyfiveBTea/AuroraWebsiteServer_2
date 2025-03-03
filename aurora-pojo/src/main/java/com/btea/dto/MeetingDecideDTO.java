package com.btea.dto;

import lombok.Data;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author: TwentyFiveBTea
 * @Date: 2025/3/3 14:46
 * @Description: 会议请假判定数据传输对象
 */
@Data
public class MeetingDecideDTO {
    // 会议理由 ID
    String meetingAbsenceId;

    // 会议理由状态
    String meetingAbsenceStatus;
}
