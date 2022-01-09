package com.douyuehan.doubao.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.douyuehan.doubao.common.api.ApiResult;
import com.douyuehan.doubao.model.dto.PositionDTO;
import com.douyuehan.doubao.model.entity.BmsPosition;
import com.douyuehan.doubao.service.IBmsPositionService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;//自动把java对象转json字符串
import java.util.List;

@RestController
@RequestMapping("/position")
public class BmsPositionController extends BaseController{

    @Resource
    private IBmsPositionService bmsPositionService;

    @GetMapping("/all")
    public ApiResult<List<BmsPosition>> getAllPosition(){
        List<BmsPosition> list = bmsPositionService.list(new
                LambdaQueryWrapper<BmsPosition>().eq(BmsPosition::isShow,true));
        return ApiResult.success(list);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ApiResult<BmsPosition> create(@RequestBody PositionDTO dto) {
        BmsPosition position = bmsPositionService.create(dto);
        return ApiResult.success(position);
    }

}
