package com.btea.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

/**
 * @Author: TwentyFiveBTea
 * @Date: 2024/12/17 13:11
 * @Description: 报名个人信息数据传输对象
 */
@Data
public class JoinDTO implements Serializable {
    // 姓名
    @NotBlank(message = "名字不能为空")
    private String name;

    // 性别
    @NotBlank(message = "性别不能为空")
    private String gender;

    // 年级
    @NotBlank(message = "年级不能为空")
    private String grade;

    // 电话
    @NotBlank(message = "电话不能为空")
    @Pattern(regexp = "^1[3-9]\\d{9}$", message = "手机号格式错误")
    private String phone;

    // 邮箱
    @NotBlank(message = "邮箱不能为空")
    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+.[a-zA-Z]{2,}$", message = "邮箱格式错误")
    private String email;

    // 专业
    @NotBlank(message = "专业不能为空")
    private String majors;

    // 方向
    @NotBlank(message = "方向不能为空")
    private String orientation;

    // 介绍
    private String introduce;
}
