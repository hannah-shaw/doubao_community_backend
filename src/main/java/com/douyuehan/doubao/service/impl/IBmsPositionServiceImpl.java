package com.douyuehan.doubao.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.douyuehan.doubao.mapper.BmsPositionMapper;
import com.douyuehan.doubao.model.dto.PositionDTO;
import com.douyuehan.doubao.model.entity.BmsPosition;
import com.douyuehan.doubao.service.IBmsPositionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
public class IBmsPositionServiceImpl extends ServiceImpl<BmsPositionMapper
        , BmsPosition> implements IBmsPositionService {

    @Override
    @Transactional(rollbackFor = Exception.class)
    public BmsPosition create(PositionDTO dto) {
        BmsPosition position = BmsPosition.builder()
                .name(dto.getName())
                .description(dto.getDescription())
                .posx(dto.getPosx())
                .posy(dto.getPosy())
                .createTime(new Date())
                .show(true)
                .build();
        this.baseMapper.insert(position);
        return position;
    }

}
