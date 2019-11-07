package com.rimi.esports.beans;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;

/**
 * ${Description}
 * @author Wang Xiaoping
 * @date 2019/11/6 14:30
 */
@ApiModel(value="com.rimi.esports.Brand")
@Data
public class Brand implements Serializable {
    /**
    * ID
    */
    @ApiModelProperty(value="ID")
    private Integer brandId;

    /**
    * 品牌名称
    */
    @ApiModelProperty(value="品牌名称")
    private String brandName;

    /**
    * 品牌图标
    */
    @ApiModelProperty(value="品牌图标")
    private String brandLogo;

    private static final long serialVersionUID = 1L;
}