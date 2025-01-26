package com.btea.mapper;

import com.btea.annotation.AutoFill;
import com.btea.dto.AlgorithmDTO;
import com.btea.entity.Algorithm;
import com.btea.entity.User;
import com.btea.enumeration.OperationType;
import com.btea.vo.AlgorithCountVO;
import com.btea.vo.AlgorithVO;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

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

    /**
     * 分页查询刷题记录
     *
     * @param algorithmDTO
     * @return
     */
    Page<AlgorithVO> pageQuery(AlgorithmDTO algorithmDTO);

    /**
     * 查询成员刷题数量
     *
     * @return
     */
    List<AlgorithCountVO> selectAlgorithmCount();
}
