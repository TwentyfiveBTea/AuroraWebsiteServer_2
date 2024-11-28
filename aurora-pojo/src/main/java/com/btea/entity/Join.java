package com.btea.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @Author: TwentyFiveBTea
 * @Date: 2024/11/28 17:47
 * @Description: 报名实体类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Join implements Serializable {
    // 主键 id
    private Integer id;

    // 姓名
    private String name;

    // 性别
    private String gender;

    // 年级
    private String grade;

    // 电话
    private String phone;

    // 邮箱
    private String email;

    // 年级
    private String majors;

    // 方向
    private String orientation;

    // 介绍
    private String introduce;

    // 创建时间
    private LocalDateTime createTime;
}
