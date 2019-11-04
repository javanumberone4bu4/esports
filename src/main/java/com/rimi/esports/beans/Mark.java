package com.rimi.esports.beans;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;

@ApiModel(value = "com.rimi.esports.beans.Mark")
@Data
public class Mark implements Serializable {
    /**
     * ID
     */
    @ApiModelProperty(value = "ID")
    private Integer markId;

    /**
     * 用户名
     */
    @ApiModelProperty(value = "用户名")
    private String markName;

    /**
     * 积分数
     */
    @ApiModelProperty(value = "积分数")
    private Integer markScore;

    /**
     * 来源
     */
    @ApiModelProperty(value = "来源")
    private String markSource;

    private static final long serialVersionUID = 1L;
}
