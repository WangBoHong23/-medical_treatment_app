package com.zkth.app.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zk.common.dtos.ResponseResult;
import com.zk.model.appuser.dtos.AppUserLoginDTO;
import com.zk.model.appuser.pojos.AppUser;

public interface AppUserService extends IService<AppUser> {
    /**
     * 登录
     *
     * @param dto
     * @return
     */
    public ResponseResult login(AppUserLoginDTO dto);
}
