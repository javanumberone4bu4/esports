package com.rimi.esports.controller;


import com.rimi.esports.beans.Mecode;
import com.rimi.esports.beans.Sm;
import com.rimi.esports.beans.User;
import com.rimi.esports.common.*;
import com.rimi.esports.mapper.MecodeMapper;
import com.rimi.esports.service.IUserService;
import com.rimi.esports.util.PwdUtils;
import com.rimi.esports.vo.UserVo1;
import com.rimi.esports.vo.UserVo4;
import com.rimi.esports.vo.UserVo8;
import com.rimi.esports.vo.UserVo9;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


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
    @Autowired
    private MecodeMapper mecodeMapper;

    public UserController(IUserService userService) {
        this.userService = userService;
    }
    @ApiOperation(value = "查询注册账号是否存在")
    @PostMapping("/regist/isExist")
   // @ResponseBody
    public Result isExist(@RequestBody UserVo9 vo9){
        System.out.println(vo9.getUserTel());
       return userService.selectByUserTel(vo9.getUserTel());
    }
    @ApiOperation(value = "注册成功时保存用户")
    @PostMapping("/regist/insert")
   // @ResponseBody
    public Result insert(@RequestBody UserVo4 vo4){
       // System.out.println(vo4.getUser());
        User user=new User();
        user.setUserTel(vo4.getUserTel());
        user.setPassword(PwdUtils.getPwd(vo4.getUserTel()+vo4.getPassword()));
        System.out.println(user);
        System.out.println(vo4.getNumber());
        Mecode mecode = mecodeMapper.selectByUserTel(vo4.getUserTel());
        if(mecode==null){
            return new DefaultResult(ResultCode.FAIL);
        }
        if(!vo4.getNumber().equals(mecode.getNumber())){
            return new DefaultResult(ResultCode.FAIL);
        }
        return userService.insert(user,vo4.getNumber());
    }
    @ApiOperation(value = "获取验证码")
    @PostMapping("/regist/getNum")
   // @ResponseBody
    public Result getNum(@RequestBody UserVo9 vo9){
        //model.addAttribute("验证码",userService.getNum(telephone));
        System.out.println(vo9.getUserTel());
        return userService.getNum(vo9.getUserTel());
    }
    @ApiOperation(value = "登录时账号密码是否正确")
    @PostMapping("/login")
    public Result login(@RequestBody UserVo8 vo8){
        System.out.println(vo8);
        Sm sm=new Sm();
        sm.setSmImage(vo8.getAvatarUrl());
        sm.setSmAddress(vo8.getCountry()+vo8.getProvince()+vo8.getCity());
        sm.setSmSex(vo8.getGender());
        sm.setSmName(vo8.getNickName());
        return userService.weiXinLogin(vo8.getOpenid(),sm);
    }
    @ApiOperation(value = "登录时账号密码是否正确")
    @PostMapping("/login/common")
   // @ResponseBody
    public Result login( @RequestBody  User user){
        //System.out.println(model);
        return userService.selectByUserTelAndPassword(user);
    }
    @ApiOperation(value = "修改密码")
    @PostMapping("/user/update")
    public Result updatePassword(@RequestBody User user){
        return userService.updatePassword(user);
    }
    @ApiOperation(value = "找回密码")
    @PostMapping("/user/findPassword")
    public Result findPassword(@RequestBody UserVo4 vo4){
        //User user=new User();
        //user.setUserTel(vo4.getUserTel());
        User user = userService.selectByUserTel2(vo4.getUserTel());
        user.setPassword(vo4.getPassword());
        System.out.println(user);
        System.out.println(vo4.getNumber());
        Mecode mecode = mecodeMapper.selectByUserTel(vo4.getUserTel());
        if(mecode==null){
            return new DefaultResult(ResultCode.FAIL);
        }
        if(!vo4.getNumber().equals(mecode.getNumber())){
            return new DefaultResult(ResultCode.FAIL);
        }
        return userService.findPassword(user,vo4.getNumber());
    }
    @ApiOperation(value ="充值" )
    @PostMapping("/user/pay")
    public Result pay(UserVo1 vo1){
      return userService.updateUserMoney(vo1.getSourceUserTel(),vo1.getTargetUserTel(),vo1.getUserMoney());
    }
}
