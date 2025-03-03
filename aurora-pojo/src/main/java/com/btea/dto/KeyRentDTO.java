package com.btea.dto;

import lombok.Data;

/**
 * @Author: TwentyFiveBTea
 * @Date: 2025/3/3 14:32
 * @Description: 归还钥匙数据传输对象
 */
@Data
public class KeyRentDTO {
    // 租赁状态
    private int leasedStatus;

    // 姓名
    private String name;

    // 学号
    private String userId;
}
