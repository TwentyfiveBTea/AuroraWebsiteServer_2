package com.btea.dto;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @Author: TwentyFiveBTea
 * @Date: 2024/12/17 20:58
 * @Description: 查看报名信息数据传输对象
 */
@Data
public class RegistrationInformationDTO implements Serializable {
    // 当前页数
    private int page;
    // 每页的大小
    private int pageSize;
    // 姓名
    private String name;
    // 专业
    private String majors;
    // 方向
    private String orientation;
}
