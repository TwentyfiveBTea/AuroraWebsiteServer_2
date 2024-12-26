package com.btea.service.impl;

import com.btea.constant.KeyLeaseStatusConstant;
import com.btea.dto.UserDTO;
import com.btea.entity.Key;
import com.btea.mapper.KeyMapper;
import com.btea.service.KeyService;
import com.btea.vo.MemberKeyVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * @Author: TwentyFiveBTea
 * @Date: 2024/12/26 10:16
 * @Description: 钥匙服务层接口实现类
 */
@Service
public class KeyServiceImpl implements KeyService {
    @Autowired
    private KeyMapper keyMapper;

    /**
     * 设置钥匙数量
     *
     * @param keysNumber
     * @return
     */
    @Override
    public int insertKey(int keysNumber) {
        int count = 0;
        for (int i = 0; i < keysNumber; i++) {
            Key key = new Key().builder()
                    .id(UUID.randomUUID().toString())
                    .leasedStatus(KeyLeaseStatusConstant.NOT_LEASED)
                    .build();
            keyMapper.insertKey(key);
            count++;
        }

        return count;
    }

    /**
     * 查询持有钥匙以及信息
     *
     * @param userDTO
     * @return
     */
    @Override
    public MemberKeyVO selectKeyByUserId(UserDTO userDTO) {
        Key key = keyMapper.selectKeyByUserId(userDTO);
        if (key == null) {
            return new MemberKeyVO();
        }

        return new MemberKeyVO().builder()
                .id(key.getId())
                .startRentTime(key.getUpdateTime().toString())
                .build();
    }

    /**
     * 查找未被租赁的钥匙
     *
     * @return
     */
    @Override
    public String selectNotLeasedKey() {
        return keyMapper.selecNotLeasedKey();
    }

    /**
     * 更新钥匙租赁状态
     *
     * @param id
     * @return
     */
    @Override
    public int updateKeyStatusLease(String id, int leasedStatus, String name, String userId) {
        Key key = new Key().builder()
                .id(id)
                .leasedStatus(leasedStatus)
                .name(name)
                .userId(userId)
                .build();
        return keyMapper.updateKeyStatusLease(key);
    }

    @Override
    public int updateKeyStatusReturn(String id, int leasedStatus) {
        Key key = new Key().builder()
                .id(id)
                .leasedStatus(leasedStatus)
                .build();
        return keyMapper.updateKeyStatusReturn(key);
    }
}
