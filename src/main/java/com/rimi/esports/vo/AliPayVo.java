package com.rimi.esports.vo;

import lombok.Data;

/**
 * @author Wang Xiaoping
 * @date 2019/11/14 0:33
 */
@Data
public class AliPayVo {
    private String userTel;
    private String goodsName;
    private String ordersNum;
    private String goodsPrice;
    private String goodsNum;
    private String goodsPricesum;
    private String ordersGetname;
    private String ordersGetaddress;
    private String ordersGetmethod;
    private String ordersGetscore;
    private String[] ids;

}
