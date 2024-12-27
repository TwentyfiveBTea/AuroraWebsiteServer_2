package com.btea.mapper;

import com.btea.annotation.AutoFill;
import com.btea.dto.UserDTO;
import com.btea.entity.Key;
import com.btea.enumeration.OperationType;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author: TwentyFiveBTea
 * @Date: 2024/12/26 10:26
 * @Description:
 */
@Mapper
public interface KeyMapper {

    /**
     * 设置钥匙数量
     * @param key
     * @return
     */
    @AutoFill(OperationType.INSERT)
    int insertKey(Key key);

    /**
     * 查询持有钥匙以及信息
     * @param userDTO
     * @return
     */
    Key selectKeyByUserId(UserDTO userDTO);

    /**
     * 查找未被租赁的钥匙
     * @return
     */
    String selecNotLeasedKey();

    /**
     * 更新钥匙租赁状态
     * @param key
     * @return
     */
    @AutoFill(OperationType.UPDATE)
    int updateKeyStatusLease(Key key);

    /**
     * 更新钥匙归还状态
     * @return
     */
    @AutoFill(OperationType.UPDATE)
    int updateKeyStatusReturn(Key key);

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
