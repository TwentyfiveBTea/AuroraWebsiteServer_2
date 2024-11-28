package com.btea.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @Author: TwentyFiveBTea
 * @Date: 2024/11/28 17:53
 * @Description: 会议实体类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Meeting implements Serializable {
    // 会议 id
    private Integer id;

    // 会议主题
    private String topic;

    // 会议内容
    private String content;

    // 会议时间
    private LocalDateTime meetingTime;

    // 创建时间
    private LocalDateTime createTime;
}
