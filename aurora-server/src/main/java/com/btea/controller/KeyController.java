package com.btea.controller;

import com.btea.constant.MessageConstant;
import com.btea.constant.StatusCodeConstant;
import com.btea.dto.UserDTO;
import com.btea.result.R;
import com.btea.service.KeyService;
import com.btea.vo.MemberKeyVO;
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


    @RequestMapping(method = RequestMethod.GET, path = "/key/rent")
    @ApiOperation("查询持有钥匙")
    public R heldKeysNumber(@RequestBody UserDTO userDTO) {
        return R.success(keyService.selectKeyByUserId(userDTO));
    }

    @RequestMapping(method = RequestMethod.PUT, path = "/key/rent")
    @ApiOperation("租赁归还钥匙")
    public R leaseReturnKey(@RequestParam int leasedStatus, @RequestParam String name, @RequestParam String userId) {
        UserDTO userDTO = new UserDTO();
        userDTO.setName(name);
        userDTO.setUserId(userId);

        MemberKeyVO memberKeyVO = keyService.selectKeyByUserId(userDTO);
        // 未租赁钥匙 -- 允许租赁
        if (memberKeyVO.getId() == null) {
            // 如果是租赁钥匙
            if (leasedStatus == -1) {
                // 先查找是否有未被租赁的钥匙
                String keyId = keyService.selectNotLeasedKey();

                if (keyId != null) {
                    int i = keyService.updateKeyStatusLease(keyId, leasedStatus, name, userId);

                    if (i == 0) {
                        return R.error(StatusCodeConstant.SERVER_ERROR, MessageConstant.SERVER_ERROR);
                    }

                    return R.success(MessageConstant.LEASE_SUCCESSFUL);
                }

                return R.success(MessageConstant.NO_REMAINING_KEYS);
            }

            if (leasedStatus == 1) {
                return R.success(MessageConstant.UNLEASED_KEYS);
            }
        }

        // 若已经有钥匙
        if (leasedStatus == -1) {
            return R.success(MessageConstant.LEASED_KEYS);
        }

        // 归还钥匙
        int i = keyService.updateKeyStatusReturn(keyService.selectKeyByUserId(userDTO).getId(), leasedStatus);
        if (i != 1) {
            return R.error(StatusCodeConstant.SERVER_ERROR, MessageConstant.SERVER_ERROR);
        }

        return R.success(MessageConstant.RETURN_SUCCESSFUL);

    }

}
