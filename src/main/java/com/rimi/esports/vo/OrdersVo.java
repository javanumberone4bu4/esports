package com.rimi.esports.vo;

import lombok.Data;

/**
 * @author Wang Xiaoping
 * @date 2019/11/13 17:11
 */
@Data
public class OrdersVo {
    private String userTel;
    private String ordersNum;
    private String ordersGetaddress;
    private String ordersGetphone;
    private String ordersStatus;
    private String goodsName;
    private Integer pageSize;
    private Integer pageNumber;
    private String[] goodsid;
}
