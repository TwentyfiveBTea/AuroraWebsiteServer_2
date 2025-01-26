package com.btea.service.impl;

import com.btea.dto.AlgorithmDTO;
import com.btea.entity.Algorithm;
import com.btea.entity.User;
import com.btea.mapper.AlgorithmMapper;
import com.btea.result.PageResult;
import com.btea.service.AlgorithmService;
import com.btea.vo.AlgorithCountVO;
import com.btea.vo.AlgorithVO;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author: TwentyFiveBTea
 * @Date: 2025/01/10 11:54
 * @Description: 算法服务层接口实现类
 */
@Service
public class AlgorithmServiceImpl implements AlgorithmService {
    @Autowired
    AlgorithmMapper algorithmMapper;

    /**
     * 提交刷题记录
     *
     * @param userId
     * @param titleUrl
     * @return
     */
    @Override
    public int insertTitleUrl(String userId, String titleUrl) {
        // 正则判断是否为所规定网址的 URL
        String patternStr = "^(https?://(www\\.)?(luogu\\.com\\.cn/record/\\d+|leetcode\\.cn/submissions/detail/\\d+))$";
        // 将正则表达式模式字符串编译为Pattern对象，方便后续进行匹配操作
        Pattern pattern = Pattern.compile(patternStr);
        // 使用编译后的Pattern对象创建Matcher对象，用于对传入的titleUrl进行匹配操作
        Matcher matcher = pattern.matcher(titleUrl);

        if (matcher.matches()) {
            try {
                // 创建URL对象，用于表示要访问的网址
                URL url = new URL(titleUrl);
                // 打开一个到指定网址的连接
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                // 设置请求方法为 GET，通常查看网页状态码使用 GET请求即可
                connection.setRequestMethod("GET");
                // 设置连接超时时间，单位为毫秒，这里设置为 5000毫秒，可根据实际情况调整
                connection.setConnectTimeout(5000);
                // 获取响应的状态码
                int responseCode = connection.getResponseCode();
                if (responseCode == 200) {
                    // 如果状态码为 200，表示请求成功，也就是网址可正常访问，相当于之前 ping通的情况
                    int status = selectUserIdByTitleUrl(userId, titleUrl);
                    if (status == 0) {
                        // 重复提交
                        return -3;
                    }

                    // 提交成功之后，设置提交次数 ++
                    algorithmMapper.updateSubmitCount(new User().builder()
                            .userId(userId)
                            .build());
                    return algorithmMapper.insertTitleUrl(new Algorithm().builder()
                            .userId(userId)
                            .titleUrl(titleUrl)
                            .build());
                } else {
                    // 如果状态码不是 200，表示网址访问出现问题，相当于之前 ping不通的情况
                    return 0;
                }
            } catch (IOException e) {
                e.printStackTrace();
                // 出现IO异常，比如无法连接到网址等情况，相当于之前执行 ing命令出现异常的情况
                return -1;
            }
        } else {
            // titleUrl不符合前面定义的两种格式要求
            return -2;
        }
    }

    /**
     * 根据 TitleUrl查询是否已经提交过
     *
     * @param titleUrl
     * @return
     */
    @Override
    public int selectUserIdByTitleUrl(String userId, String titleUrl) {
        if (userId.equals(algorithmMapper.selectUserIdByTitleUrl(titleUrl))) {
            // 如果重复提交
            return 0;
        }
        return 1;
    }

    /**
     * 更改刷题提交次数
     *
     * @param user
     */
    @Override
    public void updateSubmitCount(User user) {
        algorithmMapper.updateSubmitCount(user);
    }

    /**
     * 分页查询刷题记录
     *
     * @param algorithmDTO
     * @return
     */
    @Override
    public PageResult pageQuery(AlgorithmDTO algorithmDTO) {
        PageHelper.startPage(algorithmDTO.getPage(), algorithmDTO.getPageSize());
        Page<AlgorithVO> page = algorithmMapper.pageQuery(algorithmDTO);
        return new PageResult(page.getTotal(), page.getResult());
    }

    /**
     * 查询成员刷题数量
     *
     * @return
     */
    @Override
    public List<AlgorithCountVO> selectAlgorithmCount() {
        return algorithmMapper.selectAlgorithmCount();
    }

}
