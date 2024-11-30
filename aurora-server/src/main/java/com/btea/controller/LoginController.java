package com.btea.controller;

import com.btea.constant.JwtClaimsConstant;
import com.btea.constant.MessageConstant;
import com.btea.dto.AdminLoginDTO;
import com.btea.dto.UserLoginDTO;
import com.btea.entity.Admin;
import com.btea.entity.User;
import com.btea.properties.JwtProperties;
import com.btea.result.R;
import com.btea.service.LoginService;
import com.btea.utils.JwtUtil;
import com.btea.vo.AdminLoginVO;
import com.btea.vo.UserLoginVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: TwentyFiveBTea
 * @Date: 2024/11/28 20:48
 * @Description: 登录控制层
 */
@RestController
@RequestMapping("/login")
@Slf4j
@Api(tags = "登录接口")
public class LoginController {
    @Autowired
    private LoginService loginService;
    @Autowired
    private JwtProperties jwtProperties;

    @RequestMapping(method = RequestMethod.POST, path = "/user")
    @ApiOperation("成员登录")
    public R<UserLoginVO> userLogin(@RequestBody UserLoginDTO userLoginDTO) {
        log.info("登录: {}", userLoginDTO);
        User user = loginService.userLogin(userLoginDTO);

        // 登录成功，生成 jwt令牌
        Map<String, Object> claims = new HashMap<>();
        claims.put(JwtClaimsConstant.USER_ID, user.getUserId());
        String token = JwtUtil.createJWT(jwtProperties.getUserTokenName(), jwtProperties.getUserTtl(), claims);

        UserLoginVO userLoginVO = UserLoginVO.builder()
                .userId(user.getUserId())
                .name(user.getName())
                .token(token)
                .build();

        return R.success(MessageConstant.LOGIN_SUCCESSFUL, userLoginVO);
    }

    @RequestMapping(method = RequestMethod.POST, path = "/admin")
    @ApiOperation("管理员登录")
    public R<AdminLoginVO> adminLogin(@RequestBody AdminLoginDTO adminLoginDTO) {
        log.info("登录: {}", adminLoginDTO);
        Admin admin = loginService.adminLogin(adminLoginDTO);

        // 登录成功，生成 jwt令牌
        // TODO 同上，写生成 jwt令牌的业务代码
        HashMap<String, Object> claims = new HashMap<>();
        claims.put(JwtClaimsConstant.ADMIN_ID, admin.getUserName());
        String token = JwtUtil.createJWT(jwtProperties.getAdminTokenName(), jwtProperties.getAdminTtl(), claims);

        AdminLoginVO adminLoginVO = AdminLoginVO.builder()
                .userName(admin.getUserName())
                .token(token)
                .build();

        return R.success(MessageConstant.LOGIN_SUCCESSFUL, adminLoginVO);
    }

}
