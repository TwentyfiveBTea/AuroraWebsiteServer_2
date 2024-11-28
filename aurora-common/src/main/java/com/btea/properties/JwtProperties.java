package com.btea.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Author: TwentyFiveBTea
 * @Date: 2024/11/28 21:50
 * @Description: jwt令牌配置
 */
@Component
@ConfigurationProperties(prefix = "aurora.jwt")
@Data
public class JwtProperties {

    // 成员令牌配置
    private String userSecretKey;
    private long userTtl;
    private String userTokenName;

    //管理员令牌配置
    private String adminSecretKey;
    private long adminTtl;
    private String adminTokenName;
}
