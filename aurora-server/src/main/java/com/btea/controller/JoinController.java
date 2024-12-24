package com.btea.controller;

import com.btea.constant.MessageConstant;
import com.btea.constant.StatusCodeConstant;
import com.btea.dto.JoinDTO;
import com.btea.dto.RegistrationInformationDTO;
import com.btea.result.PageResult;
import com.btea.result.R;
import com.btea.service.JoinService;
import com.btea.vo.JoinVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

/**
 * @Author: TwentyFiveBTea
 * @Date: 2024/12/17 13:06
 * @Description: 报名控制层
 */

@RestController
@Slf4j
@Api(tags = "报名接口")
public class JoinController {
    @Autowired
    private JoinService joinService;

    @RequestMapping(method = RequestMethod.POST, path = "/join")
    @ApiOperation("提交个人信息")
    public R join(@RequestBody JoinDTO joinDTO) {
        int status = joinService.insertUser(joinDTO);
        // 如果状态值为 0， 插入失败
        if (status == 0) {
            return R.error(StatusCodeConstant.SERVER_ERROR, MessageConstant.SERVER_ERROR);
        }

        return R.success(MessageConstant.INFORMATION_SUBMITTED_SUCCESSFULLY);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/join")
    @ApiOperation("获取页面开放状态")
    public R join() {
        String status = joinService.selectJoinStatus();
        if (status == null) {
            // 如果查询不到
            return R.error(StatusCodeConstant.SERVER_ERROR, MessageConstant.SERVER_ERROR);
        }

        return R.success(status);
    }

    @RequestMapping(method = RequestMethod.PUT, path = "/admin/join/state/manage")
    @ApiOperation("更改报名页面开放状态")
    public R JoinStatus(@RequestParam String status) {
        String newStatus = joinService.updateJoinStatus(status);
        if (Objects.equals(newStatus, status)) {
            // 如果前后状态一致 -- 更新失败
            return R.error(StatusCodeConstant.SERVER_ERROR, MessageConstant.UPDATE_STATUS_FAILED);
        }

        return R.success(newStatus);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/admin/join/manage")
    public R<PageResult<JoinVO>> RegistrationInformation(RegistrationInformationDTO registrationInformationDTO) {
        // TODO 继续完成如下分页查询逻辑

    }
}