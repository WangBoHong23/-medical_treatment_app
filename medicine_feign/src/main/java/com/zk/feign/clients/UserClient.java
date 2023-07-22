package com.zk.feign.clients;

import com.zk.common.dtos.ResponseResult;
import com.zk.feign.falback.UserClientFallback;
import com.zk.feign.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "UserService",fallback = UserClientFallback.class)
public interface UserClient {
    @GetMapping("/user/{id}")
    ResponseResult findById(@PathVariable("id") Long id);
}
