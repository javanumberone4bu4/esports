package com.rimi.esports.beans;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;

/**
 * ${Description}
 * @author Wang Xiaoping
 * @date 2019/11/6 14:29
 */
@ApiModel(value="com.rimi.esports.Mark")
@Data
public class Mark implements Serializable {
    /**
    * ID
    */
    @ApiModelProperty(value="ID")
    private Integer markId;

    /**
    * 用户名
    */
    @ApiModelProperty(value="用户名")
    private String userTel;

    /**
    * 积分数
    */
    @ApiModelProperty(value="积分数")
    private Integer markScore;

    /**
    * 来源
    */
    @ApiModelProperty(value="来源")
    private String markSource;

    private static final long serialVersionUID = 1L;
}