package com.douyuehan.doubao.model.dto;
import lombok.Data;
import java.io.Serializable;

@Data
public class BillboardDTO implements Serializable {

    private static final long serialVersionUID = -5957433707110390852L;

    /**
     * 标题
     */
    private String content;
}
