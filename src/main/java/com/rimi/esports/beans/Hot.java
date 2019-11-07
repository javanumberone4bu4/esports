package com.rimi.esports.beans;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;

/**
 * ${Description}
 * @author Wang Xiaoping
 * @date 2019/11/6 21:54
 */
@ApiModel(value="com.rimi.esports.Hot")
@Data
public class Hot implements Serializable {
    /**
    * ID
    */
    @ApiModelProperty(value="ID")
    private Integer hotId;

    /**
    * 用户头像
    */
    @ApiModelProperty(value="用户头像")
    private String hotUserimage;

    /**
    * 用户名字
    */
    @ApiModelProperty(value="用户名字")
    private String smName;

    /**
    * 时间
    */
    @ApiModelProperty(value="时间")
    private String hotTime;

    /**
    * 内容
    */
    @ApiModelProperty(value="内容")
    private String hotContent;

    /**
    * 图片
    */
    @ApiModelProperty(value="图片")
    private String hotPicture;

    /**
    * 地区
    */
    @ApiModelProperty(value="地区")
    private String location;

    private static final long serialVersionUID = 1L;
}