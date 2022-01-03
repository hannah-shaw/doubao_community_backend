package com.douyuehan.doubao.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.douyuehan.doubao.common.api.ApiResult;
import com.douyuehan.doubao.model.entity.BmsBillboard;
import com.douyuehan.doubao.model.entity.UmsUser;
import com.douyuehan.doubao.service.IUmsUserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/admin")//第一层路径从mapping注入
public class UmsAdminController {

    @Resource//依赖注入找到实现类
    private IUmsUserService umsUserService;

    @GetMapping("/userall")
    public ApiResult<List<UmsUser>> getAllNotices(){
        List<UmsUser> list = umsUserService.list();
        return ApiResult.success(list);
    }
}
