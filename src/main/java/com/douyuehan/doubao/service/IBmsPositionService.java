package com.douyuehan.doubao.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.douyuehan.doubao.model.dto.PositionDTO;
import com.douyuehan.doubao.model.entity.BmsPosition;

public interface IBmsPositionService extends IService<BmsPosition> {

    /**
     * 发布
     *
     * @param dto
     * @return
     */
    BmsPosition create(PositionDTO dto);
}
