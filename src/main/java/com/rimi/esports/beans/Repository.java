package com.rimi.esports.beans;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.List;

import lombok.Data;

/**
 * ${Description}
 * @author Wang Xiaoping
 * @date 2019/11/13 11:58
 */
@ApiModel(value="com.rimi.esports.Repository")
@Data
public class Repository implements Serializable {
    /**
    * ID
    */
    @ApiModelProperty(value="ID")
    private Integer rId;

    /**
    * 商品ID
    */
    @ApiModelProperty(value="商品ID")
    private Integer rGid;

    /**
    * 商品来源
    */
    @ApiModelProperty(value="商品来源")
    private String rGsource;

    /**
    * 商品名字
    */
    @ApiModelProperty(value="商品名字")
    private String rGname;

    /**
    * 商品图片
    */
    @ApiModelProperty(value="商品图片")
    private String rGphoto;

    /**
    * 商品单价
    */
    @ApiModelProperty(value="商品单价")
    private Double rGprice;

    /**
    * 品牌ID
    */
    @ApiModelProperty(value="品牌ID")
    private Integer rBid;

    /**
    * 商品分类
    */
    @ApiModelProperty(value="商品分类")
    private String rGclassify;

    /**
    * 商品特性
    */
    @ApiModelProperty(value="商品特性")
    private String rGshowtime;

    /**
    * 商品描述
    */
    @ApiModelProperty(value="商品描述")
    private String rGdescription;

    /**
    * 商品特性2
    */
    @ApiModelProperty(value="商品特性2")
    private String rGuptime;

    /**
    * 商品发货位置
    */
    @ApiModelProperty(value="商品发货位置")
    private String rGlocation;

    /**
    * 商品数量
    */
    @ApiModelProperty(value="商品数量")
    private Integer rGnum;

    /**
    * 商品小计
    */
    @ApiModelProperty(value="商品小计")
    private Double rGpricesum;

    /**
    * 商品属性
    */
    @ApiModelProperty(value="商品属性")
    private String rGproperty;
    private List<Goods> list;
    private static final long serialVersionUID = 1L;
}