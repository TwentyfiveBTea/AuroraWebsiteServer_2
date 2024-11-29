package com.btea.dto;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * @Author: TwentyFiveBTea
 * @Date: 2024/11/28 20:54
 * @Description: 成员登录数据传输对象
 */
@Data
public class UserLoginDTO implements Serializable {
    // 学号
    @NotBlank(message = "学号不能为空")
    private String userId;
    // 密码
    @NotBlank(message = "密码不能为空")
    private String password;
}
