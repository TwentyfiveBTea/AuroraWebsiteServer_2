package com.btea.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: TwentyFiveBTea
 * @Date: 2025/01/26 14:57
 * @Description: 个人刷题记录数据视图对象
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AlgorithVO {
    // 题目链接
    private String titleUrl;
    // 创建时间
    private String createTime;
}
