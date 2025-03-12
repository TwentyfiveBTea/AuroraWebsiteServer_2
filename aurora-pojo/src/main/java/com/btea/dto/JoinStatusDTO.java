package com.btea.dto;

import lombok.Data;

/**
 * @Author: TwentyFiveBTea
 * @Date: 2025/3/11 18:55
 * @Description: 加入我们页面开放状态
 */
@Data
public class JoinStatusDTO {
    /**
     * 开放状态 1：开放 0:关闭
     */
    private String status;
}
