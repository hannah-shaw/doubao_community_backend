package com.douyuehan.doubao.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.douyuehan.doubao.common.api.ApiResult;
import com.douyuehan.doubao.model.entity.BmsPost;
import com.douyuehan.doubao.model.entity.BmsTag;
import com.douyuehan.doubao.service.IBmsTagService;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/tag")
public class BmsTagController extends BaseController {

    @Resource
    private IBmsTagService bmsTagService;
    //根据标签名返回文章集合
    @GetMapping("/{name}")
    public ApiResult<Map<String, Object>> getTopicsByTag(
            @PathVariable("name") String tagName,
            @RequestParam(value = "page", defaultValue = "1") Integer page,
            @RequestParam(value = "size", defaultValue = "10") Integer size) {
        //新建Map因为返回两个数据，一个是标签下所有帖子和热门标签
        Map<String, Object> map = new HashMap<>(16);
        //定义查询
        LambdaQueryWrapper<BmsTag> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(BmsTag::getName, tagName);
        //根据名字找到tag对象
        BmsTag one = bmsTagService.getOne(wrapper);
        Assert.notNull(one, "话题不存在，或已被管理员删除");
        //传入tagid和分页的对象 实现在impl中
        Page<BmsPost> topics = bmsTagService.selectTopicsByTagId(new Page<>(page, size), one.getId());
        // 其他热门标签
        Page<BmsTag> hotTags = bmsTagService.page(new Page<>(1, 10),
                //查询语句 不等于当前帖子id 按照帖子数量降序排序 返回10个标签
                new LambdaQueryWrapper<BmsTag>()
                        .notIn(BmsTag::getName, tagName)
                        .orderByDesc(BmsTag::getTopicCount));

        map.put("topics", topics);
        map.put("hotTags", hotTags);

        return ApiResult.success(map);
    }

}
