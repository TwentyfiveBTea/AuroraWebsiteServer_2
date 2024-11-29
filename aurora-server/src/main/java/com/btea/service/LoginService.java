package com.btea.service;

import com.btea.dto.AdminLoginDTO;
import com.btea.dto.UserLoginDTO;
import com.btea.entity.Admin;
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
    User userLogin(UserLoginDTO userLoginDTO);

    /**
     * 管理员登录
     *
     * @param adminLoginDTO
     * @return
     */
    Admin adminLogin(AdminLoginDTO adminLoginDTO);
}
