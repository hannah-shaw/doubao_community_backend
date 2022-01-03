package com.douyuehan.doubao.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.douyuehan.doubao.mapper.BmsPositionMapper;
import com.douyuehan.doubao.model.entity.BmsPosition;
import com.douyuehan.doubao.service.IBmsPositionService;
import org.springframework.stereotype.Service;

@Service
public class IBmsPositionServiceImpl extends ServiceImpl<BmsPositionMapper
        , BmsPosition> implements IBmsPositionService {

}
