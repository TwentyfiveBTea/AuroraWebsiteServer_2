package com.btea.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Author: TwentyFiveBTea
 * @Date: 2024/12/17 21:02
 * @Description: 页面状态实体类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PathStatus implements Serializable {
    // 路径
    private String path;

    // 状态 开启 -- 1， 关闭 -- 0
    private String status;
}
