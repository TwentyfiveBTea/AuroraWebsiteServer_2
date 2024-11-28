package com.btea.exception;

/**
 * @Author: TwentyFiveBTea
 * @Date: 2024/11/28 21:24
 * @Description: 业务异常
 */
public class BaseException extends RuntimeException {

    public BaseException() {
    }

    public BaseException(String msg) {
        super(msg);
    }

}
