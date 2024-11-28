package com.btea.service;

import com.btea.dto.UserLoginDTO;
import com.btea.entity.User;

/**
 * @Author: TwentyFiveBTea
 * @Date: 2024/11/28 21:03
 * @Description: 登录服务层
 */
public interface LoginService {
    /**
     * 成员登录
     *
     * @param userLoginDTO
     */
    User login(UserLoginDTO userLoginDTO);
}
