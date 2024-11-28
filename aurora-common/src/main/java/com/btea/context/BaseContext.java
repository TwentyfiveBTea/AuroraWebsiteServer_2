package com.btea.context;

/**
 * @Author: TwentyFiveBTea
 * @Date: 2024/11/28 20:34
 * @Description: 获取当前 id
 */
public class BaseContext {
    public static ThreadLocal<Long> threadLocal = new ThreadLocal<>();

    public static void setCurrentId(Long id) {
        threadLocal.set(id);
    }

    public static Long getCurrentId() {
        return threadLocal.get();
    }
}
