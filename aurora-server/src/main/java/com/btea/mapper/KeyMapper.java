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
     * 查询持有钥匙数量以及信息
     * @param userDTO
     * @return
     */
    Key selectselectKeyByUserId(UserDTO userDTO);
}
