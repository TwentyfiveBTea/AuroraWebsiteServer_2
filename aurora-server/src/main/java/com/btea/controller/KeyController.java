package com.btea.controller;

import com.btea.constant.MessageConstant;
import com.btea.constant.StatusCodeConstant;
import com.btea.dto.UserDTO;
import com.btea.result.R;
import com.btea.service.KeyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

/**
 * @Author: TwentyFiveBTea
 * @Date: 2024/12/26 10:14
 * @Description: 钥匙控制层
 */
@RestController
@Slf4j
@Api(tags = "钥匙接口")
public class KeyController {
    @Autowired
    private KeyService keyService;

    @RequestMapping(method = RequestMethod.PUT, path = "/admin/key/manage/set")
    @ApiOperation("上传钥匙数量")
    public R setKeyNumber(@RequestParam int keysNumber) {
        int count = keyService.insertKey(keysNumber);

        if (count != 0) {
            return R.success(MessageConstant.UPDATE_SUCCESSFULLY, count);
        }

        return R.error(StatusCodeConstant.SERVER_ERROR, MessageConstant.SERVER_ERROR);
    }


    @RequestMapping(method = RequestMethod.GET,path = "/key/rent")
    @ApiOperation("查询持有钥匙数量")
    public R heldKeysNumber(@RequestBody UserDTO userDTO){
        // TODO 完成剩下逻辑代码
    }


}
