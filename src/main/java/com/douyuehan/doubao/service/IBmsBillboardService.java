package com.douyuehan.doubao.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.douyuehan.doubao.model.dto.BillboardDTO;
import com.douyuehan.doubao.model.dto.CreateTopicDTO;
import com.douyuehan.doubao.model.entity.BmsBillboard;
import com.douyuehan.doubao.model.entity.BmsPost;
import com.douyuehan.doubao.model.entity.UmsUser;

public interface IBmsBillboardService extends IService<BmsBillboard> {
    /**
     * 发布
     *
     * @param dto
     * @return
     */
    BmsBillboard create(BillboardDTO dto);
}
