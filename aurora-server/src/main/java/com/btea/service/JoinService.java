package com.btea.service;


import com.btea.dto.JoinDTO;
import com.btea.dto.RegistrationInformationDTO;
import com.btea.result.PageResult;

/**
 * @Author: TwentyFiveBTea
 * @Date: 2024/12/17 13:33
 * @Description: 报名服务层接口
 */
public interface JoinService {
    /**
     * 提交个人信息
     *
     * @param joinDTO
     * @return
     */
    int insertUser(JoinDTO joinDTO);

    /**
     * 查询页面开放状态
     *
     * @return
     */
    String selectJoinStatus();

    /**
     * 更改报名页面开放状态，并返回修改后开放状态
     *
     * @param status
     * @return
     */
    void updateJoinStatus(String status);

    /**
     * 分页查询报名信息
     * @param registrationInformationDTO
     * @return
     */
    PageResult pageQuery(RegistrationInformationDTO registrationInformationDTO);
}
