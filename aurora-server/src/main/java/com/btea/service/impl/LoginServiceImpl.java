package com.btea.service.impl;

import com.btea.constant.MessageConstant;
import com.btea.dto.UserLoginDTO;
import com.btea.entity.User;
import com.btea.exception.AccountNotFoundException;
import com.btea.exception.PasswordErrorException;
import com.btea.mapper.LoginMapper;
import com.btea.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

/**
 * @Author: TwentyFiveBTea
 * @Date: 2024/11/28 21:04
 * @Description: 登录服务层接口
 */
@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginMapper loginMapper;

    /**
     * 成员登录
     *
     * @param userLoginDTO
     */
    @Override
    public User login(UserLoginDTO userLoginDTO) {
        String userId = userLoginDTO.getUserId();
        String password = userLoginDTO.getPassword();

        User user = loginMapper.getByUserId(userId);

        if (user == null) {
            // 如果查询的成员不存在
            throw new AccountNotFoundException(MessageConstant.ACCOUNT_NOT_FOUND);
        }

        // 比较密码是否正确
        password = DigestUtils.md5DigestAsHex(password.getBytes());
        if (!password.equals(user.getPassword())) {
            // 密码错误
            throw new PasswordErrorException(MessageConstant.PASSWORD_ERROR);
        }

        return user;
    }
}
