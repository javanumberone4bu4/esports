package com.rimi.esports.beans;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;

/**
 * ${Description}
 * @author Wang Xiaoping
 * @date 2019/11/7 22:46
 */
@ApiModel(value="com.rimi.esports.Mecode")
@Data
public class Mecode implements Serializable {
    /**
    * ID
    */
    @ApiModelProperty(value="ID")
    private Integer mecodeId;

    /**
    * 电话号码
    */
    @ApiModelProperty(value="电话号码")
    private String usertel;

    /**
    * 验证码
    */
    @ApiModelProperty(value="验证码")
    private String number;

    private static final long serialVersionUID = 1L;
}