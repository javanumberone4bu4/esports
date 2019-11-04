package com.rimi.esports.beans;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;

@ApiModel(value = "com.rimi.esports.beans.Goods")
@Data
public class Goods implements Serializable {
    /**
     * ID
     */
    @ApiModelProperty(value = "ID")
    private Integer goodsId;

    /**
     * 来源用户
     */
    @ApiModelProperty(value = "来源用户")
    private String goodsSource;

    /**
     * 商品名称
     */
    @ApiModelProperty(value = "商品名称")
    private String goodsName;

    /**
     * 商品图片
     */
    @ApiModelProperty(value = "商品图片")
    private String goodsPhoto;

    /**
     * 商品价格
     */
    @ApiModelProperty(value = "商品价格")
    private Double goodsPrice;

    /**
     * 品牌ID
     */
    @ApiModelProperty(value = "品牌ID")
    private Integer goodsBrandId;

    /**
     * 商品分类路径
     */
    @ApiModelProperty(value = "商品分类路径")
    private String goodsClassify;

    /**
     * 发布时间
     */
    @ApiModelProperty(value = "发布时间")
    private String goodsShowTime;

    /**
     * 商品描述
     */
    @ApiModelProperty(value = "商品描述")
    private String goodsDescription;

    /**
     * 上架时间
     */
    @ApiModelProperty(value = "上架时间")
    private String goodsUpTime;

    /**
     * 单位
     */
    @ApiModelProperty(value = "单位")
    private String goodsLocation;

    private static final long serialVersionUID = 1L;
}
