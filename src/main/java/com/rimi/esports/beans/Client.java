package com.rimi.esports.beans;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;

@ApiModel(value = "com.rimi.esports.beans.Client")
@Data
public class Client implements Serializable {
    /**
     * ID
     */
    @ApiModelProperty(value = "ID")
    private Integer clientId;

    /**
     * 用户名
     */
    @ApiModelProperty(value = "用户名")
    private String clientUsername;

    /**
     * 密码
     */
    @ApiModelProperty(value = "密码")
    private String clientPassword;

    /**
     * 昵称
     */
    @ApiModelProperty(value = "昵称")
    private String clientName;

    /**
     * 其他联系方式
     */
    @ApiModelProperty(value = "其他联系方式")
    private String clientConnMethod;

    /**
     * 公众号
     */
    @ApiModelProperty(value = "公众号")
    private String clientPublicNum;

    private static final long serialVersionUID = 1L;
}
