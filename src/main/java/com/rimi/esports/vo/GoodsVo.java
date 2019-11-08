package com.rimi.esports.vo;

import lombok.Data;

/**
 * 商品临时参数
 *
 * @author Wang Xiaoping
 * @date 2019/11/8 16:01
 */
@Data
public class GoodsVo {
    private String goodsPhoto;
    private String goodsDescription;
    private String goodsClassify;
    private double goodsPrice;
    private String goodsSource;
    private int goodsNum;
    private String goodsLocation;
    private String nickName;
    private double goodsPricesum;
}
