package com.zk.feign.falback;

import com.zk.common.dtos.ResponseResult;
import com.zk.common.enums.AppHttpCodeEnum;
import com.zk.feign.clients.UserClient;
import org.springframework.stereotype.Component;
@Component
public class UserClientFallback implements UserClient {

    @Override
    public ResponseResult findById(Long id) {
        return ResponseResult.feignErr(AppHttpCodeEnum.SERVER_ERROR);
    }
}

