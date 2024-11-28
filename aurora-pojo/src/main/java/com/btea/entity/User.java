package com.btea.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Author: TwentyFiveBTea
 * @Date: 2024/11/28 18:02
 * @Description: 成员实体类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User implements Serializable {

    // 学号
    private String userId;

    // 姓名
    private String name;

    // 年级
    private String grade;

    // 方向
    private String orientation;

    // 密码
    private String password;

}
