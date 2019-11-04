package com.rimi.esports.beans;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.math.BigDecimal;
import lombok.Data;

@ApiModel(value = "com.rimi.esports.beans.Orders")
@Data
public class Orders implements Serializable {
    /**
     * ID
     */
    @ApiModelProperty(value = "ID")
    private Integer ordersId;

    /**
     * 用户名
     */
    @ApiModelProperty(value = "用户名")
    private String ordersUsername;

    /**
     * 订单编号
     */
    @ApiModelProperty(value = "订单编号")
    private String ordersNum;

    /**
     * 下单时间
     */
    @ApiModelProperty(value = "下单时间")
    private String ordersTime;

    /**
     * 总金额
     */
    @ApiModelProperty(value = "总金额")
    private BigDecimal ordersSum;

    /**
     * 订单状态
     */
    @ApiModelProperty(value = "订单状态")
    private String ordersStatus;

    /**
     * 收货方式
     */
    @ApiModelProperty(value = "收货方式")
    private String ordersGetMethod;

    /**
     * 运费
     */
    @ApiModelProperty(value = "运费")
    private BigDecimal ordersMoney;

    /**
     * 是否支付
     */
    @ApiModelProperty(value = "是否支付")
    private String ordersPay;

    /**
     * 收货人名称
     */
    @ApiModelProperty(value = "收货人名称")
    private String ordersGetName;

    /**
     * 收货人地址
     */
    @ApiModelProperty(value = "收货人地址")
    private String ordersGetAddress;

    /**
     * 收件人手机
     */
    @ApiModelProperty(value = "收件人手机")
    private String ordersGetPhone;

    /**
     * 所得积分
     */
    @ApiModelProperty(value = "所得积分")
    private Integer ordersGetScore;

    /**
     * 快递号
     */
    @ApiModelProperty(value = "快递号")
    private String ordersExpressNum;

    /**
     * 发货时间
     */
    @ApiModelProperty(value = "发货时间")
    private String ordersGetTime;

    private static final long serialVersionUID = 1L;
}
