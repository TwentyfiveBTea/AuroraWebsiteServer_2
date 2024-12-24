package com.btea.service.impl;

import com.btea.dto.JoinDTO;
import com.btea.dto.RegistrationInformationDTO;
import com.btea.entity.Join;
import com.btea.mapper.JoinMapper;
import com.btea.result.PageResult;
import com.btea.service.JoinService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

/**
 * @Author: TwentyFiveBTea
 * @Date: 2024/12/17 13:33
 * @Description: 报名服务层接口实现类
 */
@Service
public class JoinServiceImpl implements JoinService {
    @Autowired
    private JoinMapper joinMapper;

    /**
     * 提交个人信息
     *
     * @param joinDTO
     * @return
     */
    @Override
    public int insertUser(JoinDTO joinDTO) {
        Join join = new Join();
        BeanUtils.copyProperties(joinDTO, join);
        int count = joinMapper.insertUser(join);
        // 若插入成功，则返回 1
        if (count != 1) {
            return 0;
        }
        return 1;
    }

    /**
     * 查询页面开放状态
     *
     * @return
     */
    @Override
    public String selectJoinStatus() {
        return joinMapper.selectJoinStatus();
    }

    /**
     * 更改报名页面开放状态，并返回修改后开放状态
     *
     * @param status
     * @return
     */
    @Override
    public String updateJoinStatus(String status) {
        joinMapper.updateJoinStatus(status);
        return joinMapper.selectJoinStatus();
    }

    @Override
    public PageResult pageQuery(RegistrationInformationDTO registrationInformationDTO) {
        PageHelper.startPage(registrationInformationDTO.getPage(),registrationInformationDTO.getPageSize());
    }

}
