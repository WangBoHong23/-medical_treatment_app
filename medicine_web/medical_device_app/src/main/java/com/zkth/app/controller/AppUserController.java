package com.zkth.app.controller;


import com.zk.common.dtos.ResponseResult;
import com.zk.model.appuser.dtos.AppUserLoginDTO;
import com.zkth.app.service.AppUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/app/users")
@Slf4j
@Api(tags = "用户管理接口")
public class AppUserController {
    @Autowired
    private AppUserService appUserService;

    /**
     * 登录
     *
     * @param dto
     * @return
     */
    @PostMapping("/login")
    @ApiOperation("用户登录")
    public ResponseResult login(@RequestBody AppUserLoginDTO dto) {
        log.info("用户登录：{}", dto);
        return appUserService.login(dto);
    }
}
