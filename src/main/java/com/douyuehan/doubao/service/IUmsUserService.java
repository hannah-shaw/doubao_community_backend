package com.douyuehan.doubao.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.douyuehan.doubao.model.dto.LoginDTO;
import com.douyuehan.doubao.model.dto.RegisterDTO;
import com.douyuehan.doubao.model.entity.UmsUser;
import com.douyuehan.doubao.model.vo.ProfileVO;


public interface IUmsUserService extends IService<UmsUser> {

    /**
     * 注册功能
     *
     * @param dto
     * @return 注册对象
     */
    UmsUser executeRegister(RegisterDTO dto);
    /**
     * @Description: 获取用户信息
     *
     * @param username 用户名
     * @return dbUser
     */
    UmsUser getUserByUsername(String username);
    /**
     * @Description: 用户登录
     *
     * @param dto
     * @return 生成的JWT的token
     */
    String executeLogin(LoginDTO dto);
    /**
     * @Description: 获取用户信息
     *
     * @param id 用户ID
     * @return
     */
    ProfileVO getUserProfile(String id);
}
