package com.btea.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: TwentyFiveBTea
 * @Date: 2025/01/07 15:45
 * @Description: 钥匙租赁情况视图对象
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class KeysLeaseStatusVO {
    // 钥匙 id
    private String id;
    // 姓名
    private String name;
    // 租界时间
    private String leasedTime;
    // 已租借天数
    private String leasedDays;
}
