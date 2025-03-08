package com.btea.controller;

import com.btea.constant.MessageConstant;
import com.btea.constant.StatusCodeConstant;
import com.btea.dto.KeyRentDTO;
import com.btea.dto.KeysNumberDTO;
import com.btea.dto.UserDTO;
import com.btea.result.R;
import com.btea.service.KeyService;
import com.btea.vo.KeyVO;
import com.btea.vo.MemberKeyVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: TwentyFiveBTea
 * @Date: 2024/12/26 10:14
 * @Description: 钥匙控制层
 */
@CrossOrigin
@RestController
@Slf4j
@Api(tags = "钥匙接口")
public class KeyController {
    @Autowired
    private KeyService keyService;

    @RequestMapping(method = RequestMethod.POST, path = "/admin/key/manage/set")
    @ApiOperation("上传钥匙数量")
    public R setKeyNumber(@RequestBody KeysNumberDTO keysNumberDTO) {
        log.info("上传钥匙数量：{}", keysNumberDTO.getKeysNumber());
        int count = keyService.insertKey(keysNumberDTO.getKeysNumber());
        log.info("上传钥匙数量中的要是数量count为：{}", count);
        if (count != 0) {
            return R.success(MessageConstant.UPDATE_SUCCESSFULLY, count);
        }

        return R.error(StatusCodeConstant.SERVER_ERROR, MessageConstant.SERVER_ERROR);
    }


    @RequestMapping(method = RequestMethod.GET, path = "/tools/key/rent")
    @ApiOperation("查询持有钥匙")
    public R heldKeysNumber(String name, String userId) {
        log.info("查询用户：{} 学号为：{} ", name, userId);
        UserDTO userDTO = new UserDTO();
        userDTO.setName(name);
        userDTO.setUserId(userId);
        return R.success(keyService.selectKeyByUserId(userDTO));
    }

    @RequestMapping(method = RequestMethod.POST, path = "/tools/key/rent")
    @ApiOperation("租赁归还钥匙")
    public R leaseReturnKey(@RequestBody KeyRentDTO keyRentDTO) {
        log.info("将姓名：{} 学号：{} 的租赁钥匙状态改为：{}", keyRentDTO.getName(), keyRentDTO.getUserId(), keyRentDTO.getLeasedStatus());
        UserDTO userDTO = new UserDTO();
        userDTO.setName(keyRentDTO.getName());
        userDTO.setUserId(keyRentDTO.getUserId());

        MemberKeyVO memberKeyVO = keyService.selectKeyByUserId(userDTO);
        // 未租赁钥匙 -- 允许租赁
        if (memberKeyVO.getId() == null) {
            // 如果是租赁钥匙
            if (keyRentDTO.getLeasedStatus() == -1) {
                // 先查找是否有未被租赁的钥匙
                String keyId = keyService.selectNotLeasedKey();

                if (keyId != null) {
                    int i = keyService.updateKeyStatusLease(keyId, keyRentDTO.getLeasedStatus(), keyRentDTO.getName(), keyRentDTO.getUserId());

                    if (i == 0) {
                        return R.error(StatusCodeConstant.SERVER_ERROR, MessageConstant.SERVER_ERROR);
                    }

                    return R.success(MessageConstant.LEASE_SUCCESSFUL);
                }

                return R.success(MessageConstant.NO_REMAINING_KEYS);
            }

            if (keyRentDTO.getLeasedStatus() == 1) {
                return R.success(MessageConstant.UNLEASED_KEYS);
            }
        }

        // 若已经有钥匙
        if (keyRentDTO.getLeasedStatus() == -1) {
            return R.success(MessageConstant.LEASED_KEYS);
        }

        // 归还钥匙
        int i = keyService.updateKeyStatusReturn(keyService.selectKeyByUserId(userDTO).getId(), keyRentDTO.getLeasedStatus());
        if (i != 1) {
            return R.error(StatusCodeConstant.SERVER_ERROR, MessageConstant.SERVER_ERROR);
        }

        return R.success(MessageConstant.RETURN_SUCCESSFUL);

    }

    @RequestMapping(method = RequestMethod.GET, path = "/tools/key")
    @ApiOperation("查询剩余钥匙")
    public R keysNumber() {
        return R.success(new KeyVO().builder()
                .keyNumber(keyService.selectAllKeys())
                .isLeased(keyService.selectIsLeasedKeys())
                .notLeased(keyService.selectAllKeys() - keyService.selectIsLeasedKeys())
                .build());
    }

    @RequestMapping(method = RequestMethod.GET, path = "/admin/key/manage")
    @ApiOperation("查询钥匙租赁情况")
    public R keysLeaseStatus() {
        return R.success(MessageConstant.QUERY_SUCCESS, keyService.selectKeysStatus());
    }
}
