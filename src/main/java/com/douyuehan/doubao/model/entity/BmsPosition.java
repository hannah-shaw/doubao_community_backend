package com.douyuehan.doubao.model.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;


@Data
@Builder
@Accessors(chain = true)
@TableName("bms_position_copy1")
@AllArgsConstructor
@NoArgsConstructor

public class BmsPosition implements Serializable{
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 位置名称
     */
    @TableField("name")
    private String name;

    /**
     * 位置x
     */
    @TableField("posx")
    private float posx;

    /**
     * 位置y
     */
    @TableField("posy")
    private float posy;

    /**
     * 设置时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private Date createTime;

    /**
     * 避难场所管理部门
     */
    @TableField("minister")
    private String minister;

    /**
     * 介绍
     */
    @TableField("description")
    private String description;

    /**
     * 1：显示，0：不显示
     */
    @Builder.Default
    @TableField("`show`")
    private boolean show = true;
}
