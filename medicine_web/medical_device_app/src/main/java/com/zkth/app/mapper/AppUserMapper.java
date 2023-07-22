package com.zkth.app.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zk.model.appuser.pojos.AppUser;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AppUserMapper extends BaseMapper<AppUser> {
}
