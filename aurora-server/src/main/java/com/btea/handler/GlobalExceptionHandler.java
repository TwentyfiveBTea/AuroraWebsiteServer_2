package com.btea.handler;

import com.btea.constant.StatusCodeConstant;
import com.btea.exception.BaseException;
import com.btea.result.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.net.BindException;

/**
 * @Author: TwentyFiveBTea
 * @Date: 2024/11/29 13:38
 * @Description: 全局异常处理器
 */

@Slf4j
public class GlobalExceptionHandler {

    /**
     * 捕获参数校验异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler(BindException.class)
    public R bindExceptionHandler(BindException e) {
        log.error("异常信息：{}", e.getMessage());
        return R.error(StatusCodeConstant.UNPROCESSABLE_ENTITY, e.getMessage());
    }
}
