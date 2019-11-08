package com.rimi.esports.beans;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;

/**
 * ${Description}
 * @author Wang Xiaoping
 * @date 2019/11/8 9:52
 */
@ApiModel(value="com.rimi.esports.Img")
@Data
public class Img implements Serializable {
    /**
    * ID
    */
    @ApiModelProperty(value="ID")
    private Integer imgId;

    /**
    * 存的页面
    */
    @ApiModelProperty(value="存的页面")
    private String imgPage;

    /**
    * 存的路径
    */
    @ApiModelProperty(value="存的路径")
    private String imgPath;

    private static final long serialVersionUID = 1L;
}