package com.btea.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @Author: TwentyFiveBTea
 * @Date: 2024/11/28 17:42
 * @Description: 算法提交实体类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Algorithm implements Serializable {
    // 题目链接
    private String titleUrl;

    // 学号
    private String userId;

    // 创建时间
    private LocalDateTime createTime;
}
