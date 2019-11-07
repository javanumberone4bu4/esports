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
@ApiModel(value="com.rimi.esports.Commoncity")
@Data
public class Commoncity implements Serializable {
    /**
    * ID
    */
    @ApiModelProperty(value="ID")
    private Integer commoncityId;

    /**
    * 用户头像
    */
    @ApiModelProperty(value="用户头像")
    private String commoncityUserimage;

    /**
    * 用户名字
    */
    @ApiModelProperty(value="用户名字")
    private String commoncityName;

    /**
    * 时间
    */
    @ApiModelProperty(value="时间")
    private String commoncityTime;

    /**
    * 内容
    */
    @ApiModelProperty(value="内容")
    private String commoncityContent;

    /**
    * 图片
    */
    @ApiModelProperty(value="图片")
    private String commoncityPicture;

    /**
    * 地区
    */
    @ApiModelProperty(value="地区")
    private String commoncityLocation;

    private static final long serialVersionUID = 1L;
}