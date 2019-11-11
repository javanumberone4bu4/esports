package com.rimi.esports.beans;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;

/**
 * ${Description}
 * @author Wang Xiaoping
 * @date 2019/11/10 14:58
 */
@ApiModel(value="com.rimi.esports.Goods")
@Data
public class Goods implements Serializable {
    private Brand brand;
    /**
    * ID
    */
    @ApiModelProperty(value="ID")
    private Integer goodsId;

    /**
    * 来源用户
    */
    @ApiModelProperty(value="来源用户")
    private String goodsSource;

    /**
    * 商品名称
    */
    @ApiModelProperty(value="商品名称")
    private String goodsName;

    /**
    * 商品图片
    */
    @ApiModelProperty(value="商品图片")
    private String goodsPhoto;

    /**
    * 商品价格
    */
    @ApiModelProperty(value="商品价格")
    private Double goodsPrice;

    /**
    * 品牌ID
    */
    @ApiModelProperty(value="品牌ID")
    private Integer brandId;

    /**
    * 商品分类路径
    */
    @ApiModelProperty(value="商品分类路径")
    private String goodsClassify;

    /**
    * 发布时间
    */
    @ApiModelProperty(value="发布时间")
    private String goodsShowtime;

    /**
    * 商品描述
    */
    @ApiModelProperty(value="商品描述")
    private String goodsDescription;

    /**
    * 上架时间
    */
    @ApiModelProperty(value="上架时间")
    private String goodsUptime;

    /**
    * 单位
    */
    @ApiModelProperty(value="单位")
    private String goodsLocation;

    @ApiModelProperty(value="null")
    private Integer goodsNum;

    @ApiModelProperty(value="null")
    private Double goodsPricesum;

    /**
    * 商品属性
    */
    @ApiModelProperty(value="商品属性")
    private String goodsProperty;

    private static final long serialVersionUID = 1L;
}