package com.rimi.esports.beans;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.math.BigDecimal;
import lombok.Data;

/**
 * ${Description}
 * @author Wang Xiaoping
 * @date 2019/11/7 22:35
 */
@ApiModel(value="com.rimi.esports.User")
@Data
public class User implements Serializable {
    /**
    * ID
    */
    @ApiModelProperty(value="ID")
    private Integer userId;

    /**
    * 手机号作用户名
    */
    @ApiModelProperty(value="手机号作用户名")
    private String userTel;

    /**
    * 密码
    */
    @ApiModelProperty(value="密码")
    private String password;

    /**
    * 用户钱包余额
    */
    @ApiModelProperty(value="用户钱包余额")
    private BigDecimal userMoney;

    @ApiModelProperty(value="null")
    private String openid;

    private static final long serialVersionUID = 1L;
}