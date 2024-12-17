package com.btea.mapper;

import com.btea.annotation.AutoFill;
import com.btea.entity.Join;
import com.btea.enumeration.OperationType;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author: TwentyFiveBTea
 * @Date: 2024/12/17 13:32
 * @Description: 报名访问层接口
 */
@Mapper
public interface JoinMapper {
    /**
     * 提交个人信息
     *
     * @param join
     * @return
     */
    @AutoFill(value = OperationType.INSERT)
    int insertUser(Join join);

    /**
     * 更改报名页面开放状态
     *
     * @param status
     */
    void updateJoinStatus(String status);

    /**
     * 查询当前报名页面开放状态
     *
     * @return
     */
    String selectJoinStatus();
}
