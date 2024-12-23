package com.btea.mapper;

import com.btea.entity.Admin;
import com.btea.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author: TwentyFiveBTea
 * @Date: 2024/11/28 21:15
 * @Description: 登录访问层
 */
@Mapper
public interface LoginMapper {

    /**
     * 根据 userId查询成员
     *
     * @param userId
     */
    User getByUserId(String userId);

    /**
     * 根据 userName查询管理员
     *
     * @param userName
     * @return
     */
    Admin getByUserName(String userName);
}
