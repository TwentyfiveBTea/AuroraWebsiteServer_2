package com.btea.dto;

import lombok.Data;

/**
 * @Author: TwentyFiveBTea
 * @Date: 2025/01/26 14:38
 * @Description: 个人刷题记录数据传输对象
 */
@Data
public class AlgorithmDTO {
    // 当前页数
    private int page;
    // 每页的大小
    private int pageSize;
    // 学号
    private String userId;
}
