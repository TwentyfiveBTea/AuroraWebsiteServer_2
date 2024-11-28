package com.btea;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @Author: TwentyFiveBTea
 * @Date: 2024/11/28 22:51
 * @Description: 启动类
 */
@SpringBootApplication
// 开启注解方式的事务管理
@EnableTransactionManagement
@Slf4j
public class AuroraWebsiteApplication {
    public static void main(String[] args) {
        SpringApplication.run(AuroraWebsiteApplication.class, args);
        log.info("server started");
    }
}
