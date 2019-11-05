package com.rimi.esports.controller;

import com.github.pagehelper.PageInfo;
import com.rimi.esports.beans.User;
import com.rimi.esports.common.DefaultResult;
import com.rimi.esports.common.DefaultResultData;
import com.rimi.esports.common.Result;
import com.rimi.esports.common.ResultData;
import com.rimi.esports.service.IUserService;
import com.rimi.esports.util.SendMessageUtils;
import com.rimi.esports.vo.UserVo;
import com.rimi.esports.vo.UserVo1;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.function.Supplier;

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
    public ResultData insert(User user, @RequestParam("number")String number){
        return userService.insert(user,number);
    }
    @ApiOperation(value = "获取验证码")
    @PostMapping("/regist/getNum")
    public ResultData getNum(@RequestParam("userTel") String telephone){
        //model.addAttribute("验证码",userService.getNum(telephone));
        return userService.getNum(telephone);
    }
    @ApiOperation(value = "登录时账号密码是否正确")
    @GetMapping("/login")
    public ResultData login(UserVo vo, @RequestParam("type")String type,
                            @RequestParam("code")String code,
                            HttpServletRequest request,
                            HttpServletResponse response,
                            @RequestParam("appid")String appid,
                            @RequestParam("secret")String secret){
        if(type.equals("微信登录")){
            //GET https://api.weixin.qq.com/sns/jscode2session?appid=APPID&secret=SECRET&js_code=JSCODE&grant_type=authorization_code
            try {
                Document post = Jsoup.connect("https://api.weixin.qq.com/sns/jscode2session?appid=" + appid + "&secret=" + secret + "&js_code=" + code + "&grant_type=authorization_code").post();
                Elements allElements = post.getAllElements();
                //getElementsByAttribute(String key)：通过属性名字来获取
                return new DefaultResultData(allElements);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return userService.selectByUserTelAndPassword(vo);
    }
    @ApiOperation(value = "登录时账号密码是否正确")
    @PostMapping("/login/common")
    public ResultData login(UserVo vo,Model model){
        System.out.println(model);
        return userService.selectByUserTelAndPassword(vo);
    }
    @ApiOperation(value = "修改密码")
    @PostMapping("/user/update")
    public Result updatePassword(UserVo vo){
        return userService.updatePassword(vo);
    }
    @ApiOperation(value = "找回密码")
    @PostMapping("/user/findPassword")
    public ResultData findPassword(UserVo vo,@RequestParam("number")String number){
        return userService.findPassword(vo,number);
    }
    @ApiOperation(value ="充值" )
    @PostMapping("/user/pay")
    public Result pay(UserVo1 vo1){
      return userService.updateUserMoney(vo1.getSourceUserTel(),vo1.getTargetUserTel(),vo1.getUserMoney());
    }
}
