package com.btea.service;

import com.btea.dto.AlgorithmDTO;
import com.btea.entity.User;
import com.btea.result.PageResult;
import com.btea.vo.AlgorithCountVO;

import java.util.List;

/**
 * @Author: TwentyFiveBTea
 * @Date: 2025/01/10 11:54
 * @Description: 算法服务层接口
 */
public interface AlgorithmService {
    /**
     * 提交刷题记录
     *
     * @param userId
     * @param titleUrl
     * @return
     */
    int insertTitleUrl(String userId, String titleUrl);

    /**
     * 根据 TitleUrl查询是否已经提交过
     *
     * @param titleUrl
     * @return
     */
    int selectUserIdByTitleUrl(String userId, String titleUrl);

    /**
     * 更改刷题提交次数
     *
     * @param user
     */
    void updateSubmitCount(User user);

    /**
     * 分页查询刷题记录
     *
     * @param algorithmDTO
     * @return
     */
    PageResult pageQuery(AlgorithmDTO algorithmDTO);

    /**
     * 查询成员刷题数量
     *
     * @return
     */
    List<AlgorithCountVO> selectAlgorithmCount();
}
