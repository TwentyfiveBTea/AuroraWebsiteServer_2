package com.btea.exception;

/**
 * @Author: TwentyFiveBTea
 * @Date: 2024/11/28 21:24
 * @Description: 账号不存在异常
 */
public class AccountNotFoundException extends BaseException {

    public AccountNotFoundException() {
    }

    public AccountNotFoundException(String msg) {
        super(msg);
    }

}
