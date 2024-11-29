package com.btea.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Author: TwentyFiveBTea
 * @Date: 2024/11/29 13:18
 * @Description: 管理员登录数据视图对象
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AdminLoginVO implements Serializable {
    // 用户名
    private String userName;
    // token令牌
    private String token;
}
