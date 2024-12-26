package com.btea.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: TwentyFiveBTea
 * @Date: 2024/12/26 11:21
 * @Description: 成员个人持有钥匙数据视图对象
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MemberKeyVO {
    // 钥匙 id
    private String id;

    // 租赁起始时间
    private String startRentTime;
}
