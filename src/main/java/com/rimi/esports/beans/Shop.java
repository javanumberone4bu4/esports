package com.rimi.esports.beans;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;

@ApiModel(value = "com.rimi.esports.beans.Shop")
@Data
public class Shop implements Serializable {
    /**
     * ID
     */
    @ApiModelProperty(value = "ID")
    private Integer shopId;

    /**
     * 用户名
     */
    @ApiModelProperty(value = "用户名")
    private String shopUsername;

    /**
     * 是否选中
     */
    @ApiModelProperty(value = "是否选中")
    private String shopChoose;

    /**
     * 商品ID
     */
    @ApiModelProperty(value = "商品ID")
    private Integer shopGoodsId;

    /**
     * 商品数量
     */
    @ApiModelProperty(value = "商品数量")
    private Integer shopGoodsNum;

    private static final long serialVersionUID = 1L;
}
