package com.rimi.esports.beans;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import lombok.Data;

/**
 * ${Description}
 * @author Wang Xiaoping
 * @date 2019/11/13 16:02
 */
@ApiModel(value="com.rimi.esports.Orders")
@Data
public class Orders implements Serializable {
    /**
    * ID
    */
    @ApiModelProperty(value="ID")
    private Integer ordersId;

    /**
    * 用户名
    */
    @ApiModelProperty(value="用户名")
    private String userTel;

    /**
    * 订单编号
    */
    @ApiModelProperty(value="订单编号")
    private String ordersNum;

    /**
    * 下单时间
    */
    @ApiModelProperty(value="下单时间")
    private String ordersTime;

    /**
    * 总金额
    */
    @ApiModelProperty(value="总金额")
    private BigDecimal ordersSum;

    /**
    * 订单状态
    */
    @ApiModelProperty(value="订单状态")
    private String ordersStatus;

    /**
    * 收货方式
    */
    @ApiModelProperty(value="收货方式")
    private String ordersGetmethod;

    /**
    * 运费
    */
    @ApiModelProperty(value="运费")
    private BigDecimal ordersMoney;

    /**
    * 是否支付
    */
    @ApiModelProperty(value="是否支付")
    private String ordersPay;

    /**
    * 收货人名称
    */
    @ApiModelProperty(value="收货人名称")
    private String ordersGetname;

    /**
    * 收货人地址
    */
    @ApiModelProperty(value="收货人地址")
    private String ordersGetaddress;

    /**
    * 收件人手机
    */
    @ApiModelProperty(value="收件人手机")
    private String ordersGetphone;

    /**
    * 所得积分
    */
    @ApiModelProperty(value="所得积分")
    private Integer ordersGetscore;

    /**
    * 快递号
    */
    @ApiModelProperty(value="快递号")
    private String ordersExpressnum;

    /**
    * 发货时间
    */
    @ApiModelProperty(value="发货时间")
    private String ordersGettime;

    @ApiModelProperty(value="null")
    private Integer goodsid;
    private List<Goods> list;
    private static final long serialVersionUID = 1L;
}