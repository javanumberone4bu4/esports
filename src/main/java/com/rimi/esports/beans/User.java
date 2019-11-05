package com.rimi.esports.beans;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.math.BigDecimal;
import lombok.Data;

@ApiModel(value = "com.rimi.esports.beans.User")
@Data
public class User implements Serializable {
    /**
     * ID
     */
    @ApiModelProperty(value = "ID")
    private Integer userId;

    /**
     * 手机号作用户名
     */
    @ApiModelProperty(value = "手机号作用户名")
    private String userTel;

    /**
     * 密码
     */
    @ApiModelProperty(value = "密码")
    private String password;

    /**
     * 用户钱包余额
     */
    @ApiModelProperty(value = "用户钱包余额")
    private BigDecimal userMoney;

    /**
     *
     */
    @ApiModelProperty(value = "微信请求返回参数")
    private String openId;

    private static final long serialVersionUID = 1L;
}
