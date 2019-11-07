package com.rimi.esports.beans;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;

/**
 * ${Description}
 * @author Wang Xiaoping
 * @date 2019/11/6 21:53
 */
@ApiModel(value="com.rimi.esports.Community")
@Data
public class Community implements Serializable {
    /**
    * ID
    */
    @ApiModelProperty(value="ID")
    private Integer communityId;

    /**
    * 热门
    */
    @ApiModelProperty(value="热门")
    private String hot;

    /**
    * 同城
    */
    @ApiModelProperty(value="同城")
    private String commoncity;

    private static final long serialVersionUID = 1L;
}