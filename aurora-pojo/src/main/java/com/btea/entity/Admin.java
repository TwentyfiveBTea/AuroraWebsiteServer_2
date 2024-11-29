package com.btea.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Author: TwentyFiveBTea
 * @Date: 2024/11/29 14:05
 * @Description: 管理员实体类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Admin implements Serializable {
    // 用户名
    private String userName;
    // 密码
    private String password;
}
