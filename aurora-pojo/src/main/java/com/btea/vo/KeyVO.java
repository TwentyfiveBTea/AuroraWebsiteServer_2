package com.btea.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: TwentyFiveBTea
 * @Date: 2024/12/27 09:26
 * @Description: 钥匙视图对象
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class KeyVO {
    // 钥匙数量
    private int keyNumber;
    // 被租借钥匙数量
    private int isLeased;
    // 为被租借钥匙数量
    private int notLeased;
}
