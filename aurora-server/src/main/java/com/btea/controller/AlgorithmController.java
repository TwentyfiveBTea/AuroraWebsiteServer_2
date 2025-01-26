package com.btea.controller;

import com.btea.constant.MessageConstant;
import com.btea.constant.StatusCodeConstant;
import com.btea.dto.AlgorithmDTO;
import com.btea.result.PageResult;
import com.btea.result.R;
import com.btea.service.AlgorithmService;
import com.btea.vo.AlgorithCountVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: TwentyFiveBTea
 * @Date: 2025/01/10 11:53
 * @Description: 算法控制层
 */
@RestController
@Slf4j
@Api(tags = "算法接口")
public class AlgorithmController {
    @Autowired
    AlgorithmService algorithmService;

    @RequestMapping(method = RequestMethod.POST, path = "/tools/algorithm/submit")
    @ApiOperation("提交刷题记录")
    public R submitUrl(@RequestParam String userId, @RequestParam String titleUrl) {
        int i = algorithmService.insertTitleUrl(userId, titleUrl);
        switch (i) {
            case 1:
                return R.success(MessageConstant.SUBMIT_SUCCESS);
            case 0:
            case -1:
                return R.success(MessageConstant.NETWORK_ERROR);
            case -2:
                return R.success(MessageConstant.URL_FORMAT_ERROR);
            case -3:
                return R.success(MessageConstant.REPEAT_SUBMIT);
            default:
                return R.error(StatusCodeConstant.SERVER_ERROR, MessageConstant.SERVER_ERROR);
        }
    }

    @RequestMapping(method = RequestMethod.GET, path = "/tools/algorithm")
    @ApiOperation("分页查询刷题记录")
    public R<PageResult> selectAlgorithm(AlgorithmDTO algorithmDTO) {
        PageResult pageResult = algorithmService.pageQuery(algorithmDTO);
        return R.success(pageResult);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/admin/algorithm/count")
    @ApiOperation("查询成员刷题数量")
    public R selectAlgorithmCount() {
        List<AlgorithCountVO> algorithCountVOS = algorithmService.selectAlgorithmCount();
        if (algorithCountVOS.isEmpty()) {
            return R.error(StatusCodeConstant.SERVER_ERROR, MessageConstant.SERVER_ERROR);
        }
        return R.success(MessageConstant.QUERY_SUCCESS, algorithCountVOS);
    }

}
