package com.rimi.esports.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * user参数类
 *
 * @author Wang Xiaoping
 * @date 2019/11/3 12:16
 */
@Data
@ApiModel(value = "vo",description = "登录的数据")
public class UserVo {
    @ApiModelProperty(value = "手机号做用户名",required = true,example = "18780811904")
    private String userTel;
    @ApiModelProperty(value = "密码",required = true,example = "123")
    private String password;

}
