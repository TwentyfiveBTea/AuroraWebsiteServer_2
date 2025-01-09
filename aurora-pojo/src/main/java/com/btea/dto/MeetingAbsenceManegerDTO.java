package com.btea.dto;

import lombok.Data;

/**
 * @Author: TwentyFiveBTea
 * @Date: 2025/01/09 17:53
 * @Description: 分页查询会议请假数据传输对象
 */
@Data
public class MeetingAbsenceManegerDTO {
    // 姓名
    String name;
    // 当前页数
    private int page;
    // 每页的大小
    private int pageSize;
}
