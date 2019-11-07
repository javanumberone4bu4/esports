package com.rimi.esports.beans;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;

/**
 * ${Description}
 * @author Wang Xiaoping
 * @date 2019/11/6 14:30
 */
@ApiModel(value="com.rimi.esports.Client")
@Data
public class Client implements Serializable {
    /**
    * ID
    */
    @ApiModelProperty(value="ID")
    private Integer clientId;

    /**
    * 用户名
    */
    @ApiModelProperty(value="用户名")
    private String userTel;

    /**
    * 密码
    */
    @ApiModelProperty(value="密码")
    private String password;

    /**
    * 昵称
    */
    @ApiModelProperty(value="昵称")
    private String smName;

    /**
    * 其他联系方式
    */
    @ApiModelProperty(value="其他联系方式")
    private String clientConnmethod;

    /**
    * 公众号
    */
    @ApiModelProperty(value="公众号")
    private String clientPublicnum;

    private static final long serialVersionUID = 1L;
}