package com.douyuehan.doubao.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.douyuehan.doubao.common.api.ApiResult;
import com.douyuehan.doubao.model.entity.BmsBillboard;
import com.douyuehan.doubao.service.IBmsBillboardService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;//自动把java对象转jason字符串
import java.util.List;

@RestController
@RequestMapping("/billboard")//第一层路径从mapping注入
public class BmsBillboardController extends BaseController {

    @Resource//依赖注入找到实现类
    private IBmsBillboardService bmsBillboardService;

    @GetMapping("/show")//表示处理的是get请求 查询一般用get请求 如果请求方法是/billboard/show就会匹配到这个方法
    public ApiResult<BmsBillboard> getNotices(){//返回对应实体类BmsBillboard
        List<BmsBillboard> list = bmsBillboardService.list(new
                LambdaQueryWrapper<BmsBillboard>().eq(BmsBillboard::isShow,true));
        return ApiResult.success(list.get(list.size()- 1));//返回最后一条记录
    }

    @GetMapping("/showall")
    public ApiResult<List<BmsBillboard>> getAllNotices(){
        List<BmsBillboard> list = bmsBillboardService.list(new
                LambdaQueryWrapper<BmsBillboard>().eq(BmsBillboard::isShow,true));
        return ApiResult.success(list);
    }

    @GetMapping("/getamount")
    public ApiResult<Integer> getAmount(){
        Integer amount = bmsBillboardService.list(new
                LambdaQueryWrapper<BmsBillboard>().eq(BmsBillboard::isShow,true)).size();
        return ApiResult.success(amount);
    }
}
