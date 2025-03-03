package com.btea.dto;

import lombok.Data;

/**
 * @Author: TwentyFiveBTea
 * @Date: 2025/3/3 14:12
 * @Description: 算法提交数据传输对象
 */
@Data
public class AlgorithmSetDTO {

    // 学号
    private String userId;

    // 算法 URL
    private String titleUrl;
}
