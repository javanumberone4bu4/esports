package com.rimi.esports.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * 支付参数
 *
 * @author Wang Xiaoping
 * @date 2019/11/4 12:32
 */
@Data
@ApiModel(value = "vo1",description = "支付的数据")
public class UserVo1 {
    @ApiModelProperty(value = "来源账户",required = true,example = "18780811904")
    private String sourceUserTel;
    @ApiModelProperty(value = "目标账户",required = true,example = "13438557479")
    private String targetUserTel;
    @ApiModelProperty(value = "用户余额")
    private BigDecimal userMoney;
}
