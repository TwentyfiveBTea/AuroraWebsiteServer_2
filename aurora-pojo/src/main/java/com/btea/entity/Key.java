package com.btea.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @Author: TwentyFiveBTea
 * @Date: 2024/11/28 17:50
 * @Description: 钥匙实体类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Key implements Serializable {
    // 钥匙 id
    private Integer id;

    // 租赁状态
    private String leasedStatus;

    // 租赁人姓名
    private String name;

    // 租赁人学号
    private String userId;

    // 创建时间
    private LocalDateTime createTime;

    // 修改时间
    private LocalDateTime updateTime;
}
