package com.btea.result;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author: TwentyFiveBTea
 * @Date: 2024/11/28 18:22
 * @Description: 统一返回结果类
 */
@Data
public class R<T> implements Serializable {
    // 状态码
    private Integer code;
    // 信息
    private String msg;
    // 数据
    private T data;

    public static <T> R<T> success() {
        R<T> result = new R<T>();
        result.code = 200;
        return result;
    }

    public static <T> R<T> success(String msg) {
        R<T> result = new R<T>();
        result.code = 200;
        result.msg = msg;
        return result;
    }

    public static <T> R<T> success(T object) {
        R<T> result = new R<T>();
        result.code = 200;
        result.data = object;
        return result;
    }

    public static <T> R<T> success(String msg, T object) {
        R<T> result = new R<T>();
        result.code = 200;
        result.msg = msg;
        result.data = object;
        return result;
    }

    public static <T> R<T> error(Integer code, String msg) {
        R result = new R();
        result.code = code;
        result.msg = msg;
        return result;
    }
}
