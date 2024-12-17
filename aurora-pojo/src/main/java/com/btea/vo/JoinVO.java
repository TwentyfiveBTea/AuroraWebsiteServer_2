package com.btea.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Author: TwentyFiveBTea
 * @Date: 2024/12/17 21:05
 * @Description: 报名信息视图对象
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class JoinVO implements Serializable {
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
}
