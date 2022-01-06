package com.douyuehan.doubao.model.dto;
import lombok.Data;

import java.io.Serializable;


@Data
public class PositionDTO implements Serializable {
    private static final long serialVersionUID = -5957433707110390852L;

    /**
     * 位置名称
     */
    private String name;

    /**
     * 位置x
     */
    private float posx;

    /**
     * 位置y
     */
    private float posy;

    /**
     * 避难场所管理部门
     */
    private String minister;

    /**
     * 介绍
     */
    private String description;
}
