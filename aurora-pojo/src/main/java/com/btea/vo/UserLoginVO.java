package com.btea.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Author: TwentyFiveBTea
 * @Date: 2024/11/28 21:11
 * @Description: 成员登录数据视图对象
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserLoginVO implements Serializable {
    // 姓名
    private String name;
    // 学号
    private String userId;
    // token 令牌
    private String token;
}
