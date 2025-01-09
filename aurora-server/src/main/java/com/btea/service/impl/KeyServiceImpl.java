package com.btea.service.impl;

import com.btea.constant.KeyLeaseStatusConstant;
import com.btea.dto.UserDTO;
import com.btea.entity.Key;
import com.btea.mapper.KeyMapper;
import com.btea.service.KeyService;
import com.btea.vo.KeysLeaseStatusVO;
import com.btea.vo.MemberKeyVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

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

    /**
     * 更新钥匙归还状态
     *
     * @param id
     * @param leasedStatus
     * @return
     */
    @Override
    public int updateKeyStatusReturn(String id, int leasedStatus) {
        Key key = new Key().builder()
                .id(id)
                .leasedStatus(leasedStatus)
                .build();
        return keyMapper.updateKeyStatusReturn(key);
    }

    /**
     * 查询所有钥匙数量
     *
     * @return
     */
    @Override
    public int selectAllKeys() {
        return keyMapper.selectAllKeys();
    }

    /**
     * 查询被租赁钥匙数量
     *
     * @return
     */
    @Override
    public int selectIsLeasedKeys() {
        return keyMapper.selectIsLeasedKeys();
    }

    /**
     * 查询钥匙租赁情况
     *
     * @return
     */
    @Override
    public List<KeysLeaseStatusVO> selectKeysStatus() {
        List<Key> keys = keyMapper.selectKeysStatus();
        // 获取当前时间
        LocalDateTime now = LocalDateTime.now();

        List<KeysLeaseStatusVO> keysLeaseStatusVOS = keys.stream()
                .map(key -> {
                    LocalDateTime updateTime = key.getUpdateTime();
                    // 计算两个时间的差值
                    String leasedDays = String.valueOf(ChronoUnit.DAYS.between(updateTime, now));
                    return new KeysLeaseStatusVO().builder()
                            .id(key.getId())
                            .name(key.getName())
                            .leasedTime(String.valueOf(key.getUpdateTime()))
                            .leasedDays(leasedDays)
                            .build();
                })
                .collect(Collectors.toList());

        return keysLeaseStatusVOS;
    }


}
