package com.btea.result;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @Author: TwentyFiveBTea
 * @Date: 2024/11/28 20:30
 * @Description: 翻页查询返回类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageResult<T> implements Serializable {
    // 总记录条数
    private Long total;
    // 当前页数据集合
    private List<T> records;
}
