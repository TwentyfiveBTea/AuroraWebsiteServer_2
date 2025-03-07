package com.btea.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: TwentyFiveBTea
 * @Date: 2025/01/26 15:15
 * @Description: 刷题数量数据视图对象
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AlgorithCountVO {
    // 姓名
    private String name;
    // 学号
    private String userId;
    // 刷题数量
    private String submitCount;
    // 最近一次提交时间
    private String updateTime;
}
