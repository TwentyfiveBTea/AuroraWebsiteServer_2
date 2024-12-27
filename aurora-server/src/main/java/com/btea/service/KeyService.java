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
     *
     * @param keysNumber
     * @return
     */
    int insertKey(int keysNumber);

    /**
     * 查询持有钥匙以及信息
     *
     * @param userDTO
     * @return
     */
    MemberKeyVO selectKeyByUserId(UserDTO userDTO);

    /**
     * 查找未被租赁的钥匙
     *
     * @return
     */
    String selectNotLeasedKey();

    /**
     * 更新钥匙租赁状态
     *
     * @param id
     * @return
     */
    int updateKeyStatusLease(String id, int leasedStatus, String name, String userId);

    /**
     * 更新钥匙归还状态
     * @param id
     * @param leasedStatus
     * @return
     */
    int updateKeyStatusReturn(String id, int leasedStatus);

    /**
     * 查询所有钥匙数量
     * @return
     */
    int selectAllKeys();

    /**
     * 查询被租赁钥匙数量
     * @return
     */
    int selectIsLeasedKeys();
}
