package com.btea.mapper;

import com.btea.dto.UserLoginDTO;
import com.btea.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author: TwentyFiveBTea
 * @Date: 2024/11/28 21:15
 * @Description: 登录据访问层
 */
@Mapper
public interface LoginMapper {

    /**
     * 根据 userId查询成员
     *
     * @param userId
     */
    User getByUserId(String userId);
}
