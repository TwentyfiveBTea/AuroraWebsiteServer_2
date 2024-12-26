package com.btea.handler;

import com.btea.constant.StatusCodeConstant;
import com.btea.exception.BaseException;
import com.btea.exception.PasswordErrorException;
import com.btea.result.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.net.BindException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: TwentyFiveBTea
 * @Date: 2024/11/29 13:38
 * @Description: 全局异常处理器
 */

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 捕获参数校验异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler(BaseException.class)
    public R bindExceptionHandler(BaseException e) {
        log.error("异常信息：{}", e.getMessage());
        return R.error(StatusCodeConstant.UNPROCESSABLE_ENTITY, e.getMessage());
    }

    /**
     * 捕获 DTO层参数校验异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public R methodArgumentNotValidException(MethodArgumentNotValidException e) {
        log.error("异常信息：{}", e.getMessage());
        List<ObjectError> allErrors = e.getAllErrors();
        String errorMessage = allErrors.stream()
                .map(error -> error.getDefaultMessage())
                .findFirst()
                .orElse("");
        return R.error(StatusCodeConstant.UNPROCESSABLE_ENTITY, errorMessage);
    }

}
