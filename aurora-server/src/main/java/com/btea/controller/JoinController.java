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
import org.springframework.validation.annotation.Validated;
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
    public R join(@RequestBody @Validated JoinDTO joinDTO) {
        log.info("收到个人信息：" + joinDTO);
        int status = joinService.insertUser(joinDTO);
        log.info("提交个人信息中的status为：" + status);
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
        log.info("获取页面开放状态中的status为：" + status);
        if (status == null) {
            // 如果查询不到
            return R.error(StatusCodeConstant.SERVER_ERROR, MessageConstant.SERVER_ERROR);
        }

        return R.success(status);
    }

    @RequestMapping(method = RequestMethod.PUT, path = "/admin/join/state/manage")
    @ApiOperation("更改报名页面开放状态")
    public R JoinStatus(@RequestParam String status) {
        log.info("状态将修改为：" + status);
        String oldStatus = joinService.selectJoinStatus();
        joinService.updateJoinStatus(status);
        if (Objects.equals(oldStatus, status)) {
            // 如果前后状态一致 -- 更新失败
            return R.error(StatusCodeConstant.SERVER_ERROR, MessageConstant.UPDATE_STATUS_FAILED);
        }

        return R.success(joinService.selectJoinStatus(), MessageConstant.UPDATE_STATUS_SUCCESSFULLY);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/admin/join/manage")
    @ApiOperation("分页查看报名信息")
    public R<PageResult> registrationInformation(RegistrationInformationDTO registrationInformationDTO) {
        log.info("分页要求数据为：" + registrationInformationDTO);
        PageResult pageResult = joinService.pageQuery(registrationInformationDTO);
        return R.success(pageResult);
    }
}
