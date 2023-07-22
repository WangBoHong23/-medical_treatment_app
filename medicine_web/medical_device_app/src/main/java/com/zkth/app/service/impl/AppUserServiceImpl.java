package com.zkth.app.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zk.common.dtos.ResponseResult;

import com.zk.common.enums.AppHttpCodeEnum;
import com.zk.common.utils.AppJwtUtil;
import com.zk.model.appuser.dtos.AppUserLoginDTO;
import com.zk.model.appuser.pojos.AppUser;
import com.zkth.app.mapper.AppUserMapper;
import com.zkth.app.service.AppUserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.HashMap;
import java.util.Map;


@Service
@Slf4j
public class AppUserServiceImpl extends ServiceImpl<AppUserMapper, AppUser> implements AppUserService{

        @Override
        public ResponseResult login(AppUserLoginDTO dto) {
            //1.检查参数
            if(StringUtils.isBlank(dto.getName()) || StringUtils.isBlank(dto.getPassword())){
                return ResponseResult.errorResult(AppHttpCodeEnum.PARAM_INVALID,"用户名或密码为空");
            }

            //2.查询用户
            AppUser appUser = getOne(Wrappers.<AppUser>lambdaQuery().eq(AppUser::getName, dto.getName()));
            if(appUser == null){
                return ResponseResult.errorResult(AppHttpCodeEnum.DATA_NOT_EXIST, "用户名或密码为空");
            }

            //3.比对密码
            String salt = appUser.getSalt();
            String pswd = dto.getPassword();
            pswd = DigestUtils.md5DigestAsHex((pswd + salt).getBytes());
            if(pswd.equals(appUser.getPassword())){
                //4.返回数据  jwt                            df10ef8509dc176d733d59549e7dbfaf
                Map<String,Object> map  = new HashMap<>();
                map.put("token", AppJwtUtil.getToken(appUser.getId().longValue()));
                appUser.setSalt("");
                appUser.setPassword("");
                map.put("user",appUser);
                return ResponseResult.okResult(map);

            }else {
                return ResponseResult.errorResult(AppHttpCodeEnum.LOGIN_PASSWORD_ERROR, "用户名或密码为空");
            }
        }
}
