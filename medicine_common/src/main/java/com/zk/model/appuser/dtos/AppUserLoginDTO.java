package com.zk.model.appuser.dtos;

import lombok.Data;

import java.io.Serializable;

@Data
public class AppUserLoginDTO implements Serializable {

    /**
     * 用户名
     */
    private String name;
    /**
     * 密码
     */
    private String password;

}
