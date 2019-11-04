package com.rimi.esports.beans;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;

@ApiModel(value = "com.rimi.esports.beans.Sm")
@Data
public class Sm implements Serializable {
    /**
     * ID
     */
    @ApiModelProperty(value = "ID")
    private Integer smId;

    /**
     * 昵称
     */
    @ApiModelProperty(value = "昵称")
    private String smName;

    /**
     * 真实姓名
     */
    @ApiModelProperty(value = "真实姓名")
    private String smRealName;

    /**
     * 邮箱
     */
    @ApiModelProperty(value = "邮箱")
    private String smEmail;

    /**
     * 性别
     */
    @ApiModelProperty(value = "性别")
    private String smSex;

    /**
     * 年龄
     */
    @ApiModelProperty(value = "年龄")
    private Integer smAge;

    /**
     * 工作
     */
    @ApiModelProperty(value = "工作")
    private String smJob;

    /**
     * 兴趣爱好
     */
    @ApiModelProperty(value = "兴趣爱好")
    private String smHobby;

    /**
     * 地址
     */
    @ApiModelProperty(value = "地址")
    private String smAddress;

    /**
     * 头像
     */
    @ApiModelProperty(value = "头像")
    private String smImage;

    /**
     * 信誉积分
     */
    @ApiModelProperty(value = "信誉积分")
    private Integer smMark;

    /**
     * 手机号
     */
    @ApiModelProperty(value = "手机号")
    private String telephone;

    private static final long serialVersionUID = 1L;
}
