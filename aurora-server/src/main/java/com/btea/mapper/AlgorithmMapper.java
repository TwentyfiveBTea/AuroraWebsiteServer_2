package com.btea.mapper;

import com.btea.annotation.AutoFill;
import com.btea.entity.Algorithm;
import com.btea.entity.User;
import com.btea.enumeration.OperationType;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author: TwentyFiveBTea
 * @Date: 2025/01/10 11:55
 * @Description: 算法访问层
 */
@Mapper
public interface AlgorithmMapper {
    /**
     * 提交刷题记录
     *
     * @param algorithm
     * @return
     */
    @AutoFill(OperationType.INSERT)
    int insertTitleUrl(Algorithm algorithm);

    /**
     * 根据 TitleUrl查询是否已经提交过
     *
     * @param titleUrl
     * @return
     */
    String selectUserIdByTitleUrl(String titleUrl);

    /**
     * 更改刷题提交次数
     *
     * @param user
     */
    @AutoFill(OperationType.UPDATE)
    void updateSubmitCount(User user);
}
