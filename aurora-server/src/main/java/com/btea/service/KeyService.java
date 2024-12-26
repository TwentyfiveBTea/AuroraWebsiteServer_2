package com.btea.service;

import com.btea.dto.UserDTO;
import com.btea.entity.Key;
import com.btea.vo.MemberKeyVO;

/**
 * @Author: TwentyFiveBTea
 * @Date: 2024/12/26 10:15
 * @Description: 钥匙服务层接口
 */
public interface KeyService {
    /**
     * 设置钥匙数量
     * @param keysNumber
     * @return
     */
    int insertKey(int keysNumber);

    /**
     * 查询持有钥匙数量以及信息
     * @param userDTO
     * @return
     */
    MemberKeyVO selectKeyByUserId(UserDTO userDTO);

}
