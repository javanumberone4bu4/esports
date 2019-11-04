package com.rimi.esports.controller;

import com.rimi.esports.beans.User;
import com.rimi.esports.common.Result;
import com.rimi.esports.service.IUserService;
import com.rimi.esports.util.SendMessageUtils;
import com.rimi.esports.vo.UserVo;
import com.rimi.esports.vo.UserVo1;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * user的接口层
 *
 * @author Wang Xiaoping
 * @date 2019/11/3 11:21
 */
@RestController
@CrossOrigin
@Api(tags = {"用户注册和登录相关操作"})
public class UserController {
    private final IUserService userService;

    public UserController(IUserService userService) {
        this.userService = userService;
    }
    @ApiOperation(value = "查询注册账号是否存在")
    @PostMapping("/regist/isExist")
    public Result isExist(String userTel){
       return userService.selectByUserTel(userTel);
    }
    @ApiOperation(value = "注册成功时保存用户")
    @PostMapping("/regist/insert")
    public Result insert(User user, @RequestParam("number")String number){
        return userService.insert(user,number);
    }
    @ApiOperation(value = "登录时账号密码是否正确")
    @PostMapping("/login")
    public Result login(UserVo vo){
        return userService.selectByUserTelAndPassword(vo);
    }
    @ApiOperation(value = "修改密码")
    @PostMapping("/user/update")
    public Result updatePassword(UserVo vo){
        return userService.updatePassword(vo);
    }
    @ApiOperation(value = "找回密码")
    @PostMapping("/user/findPassword")
    public Result findPassword(UserVo vo,@RequestParam("number")String number){
        return userService.findPassword(vo,number);
    }
    @ApiOperation(value ="充值" )
    @PostMapping("/user/pay")
    public Result pay(UserVo1 vo1){
      return userService.updateUserMoney(vo1.getSourceUserTel(),vo1.getTargetUserTel(),vo1.getUserMoney());
    }
}
