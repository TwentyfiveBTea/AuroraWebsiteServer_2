package com.btea.dto;

import lombok.Data;

/**
 * @Author: TwentyFiveBTea
 * @Date: 2025/01/09 15:12
 * @Description: 分页查询打卡请假数据传输对象
 */
@Data
public class TimerAbsenceManagerDTO {
    // 姓名
    private String name;
    // 当前页数
    private int page;
    // 每页的大小
    private int pageSize;
}
