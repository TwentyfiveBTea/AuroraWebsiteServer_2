package com.btea.exception;

/**
 * @Author: TwentyFiveBTea
 * @Date: 2024/11/28 21:38
 * @Description: 密码错误异常
 */
public class PasswordErrorException extends BaseException {

    public PasswordErrorException() {
    }

    public PasswordErrorException(String msg) {
        super(msg);
    }

}
