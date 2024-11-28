package com.btea.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author: TwentyFiveBTea
 * @Date: 2024/11/28 20:54
 * @Description: 成员登录数据传输对象
 */
@Data
public class UserLoginDTO implements Serializable {
    // 学号
    private String userId;
    // 密码
    private String password;
}
