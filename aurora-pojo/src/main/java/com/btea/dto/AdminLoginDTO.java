package com.btea.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * @Author: TwentyFiveBTea
 * @Date: 2024/11/29 13:17
 * @Description: 管理员登录数据传输对象
 */
@Data
public class AdminLoginDTO implements Serializable {
    // 用户名
    @NotBlank(message = "用户名不能为空")
    private String userName;
    // 密码
    @NotBlank(message = "密码不能为空")
    private String password;
}
