package com.douyuehan.doubao.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.douyuehan.doubao.mapper.BmsBillboardMapper;
import com.douyuehan.doubao.model.dto.BillboardDTO;
import com.douyuehan.doubao.model.dto.CreateTopicDTO;
import com.douyuehan.doubao.model.entity.BmsBillboard;
import com.douyuehan.doubao.model.entity.BmsPost;
import com.douyuehan.doubao.model.entity.UmsUser;
import com.douyuehan.doubao.service.IBmsBillboardService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
public class IBmsBillboardServiceImpl extends ServiceImpl<BmsBillboardMapper
        , BmsBillboard> implements IBmsBillboardService {

    @Override
    @Transactional(rollbackFor = Exception.class)
    public BmsBillboard create(BillboardDTO dto) {
        BmsBillboard billboard = BmsBillboard.builder()
                .content(dto.getContent())
                .createTime(new Date())
                .show(true)
                .build();
        this.baseMapper.insert(billboard);
        return billboard;
    }
}
