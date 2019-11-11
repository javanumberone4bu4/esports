package com.rimi.esports.beans;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.List;

import lombok.Data;

/**
 * ${Description}
 * @author Wang Xiaoping
 * @date 2019/11/6 14:29
 */
@ApiModel(value="com.rimi.esports.Shop")
@Data
public class Shop implements Serializable {
    /**
    * ID
    */
    @ApiModelProperty(value="ID")
    private Integer shopId;

    /**
    * 用户名
    */
    @ApiModelProperty(value="用户名")
    private String userTel;

    /**
    * 是否选中
    */
    @ApiModelProperty(value="是否选中")
    private String shopChoose;

    /**
    * 商品ID
    */
    @ApiModelProperty(value="商品ID")
    private Integer goodsId;

    /**
    * 商品数量
    */
    @ApiModelProperty(value="商品数量")
    private Integer shopGoodsnum;


    /**
     * 商品对象
     */
    private List<Goods> goods;

    private static final long serialVersionUID = 1L;
}