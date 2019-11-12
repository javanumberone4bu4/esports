package com.rimi.esports.controller;

import com.rimi.esports.beans.Mecode;
import com.rimi.esports.beans.Sm;
import com.rimi.esports.beans.User;
import com.rimi.esports.common.DefaultResult;
import com.rimi.esports.common.Result;
import com.rimi.esports.common.ResultCode;
import com.rimi.esports.common.ResultData;
import com.rimi.esports.mapper.MecodeMapper;
import com.rimi.esports.mapper.SmMapper;
import com.rimi.esports.mapper.UserMapper;
import com.rimi.esports.service.ISmService;
import com.rimi.esports.vo.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 个人信息表交互
 *
 * @author Wang Xiaoping
 * @date 2019/11/5 10:06
 */
@RestController
@CrossOrigin
@Api(tags = {"个人信息表操作"})
public class SmController {
    private ISmService smService;
    @Autowired
    private SmMapper smMapper;
    @Autowired
    private MecodeMapper mecodeMapper;
    @Autowired
    private UserMapper userMapper;
    public SmController(ISmService smService) {
        this.smService = smService;
    }
    @PostMapping("/sm/edit")
    @ApiOperation(value = "编辑个人信息")
    public Result updateByTelephone(@RequestBody SmVo2 vo2){
        Sm sm1 = smMapper.selectByTelephone(vo2.getUserTel());
        if(sm1==null){
            Sm sm2=new Sm();
            if(vo2.getSmAge()!=null) {
                sm2.setSmAge(Integer.parseInt(vo2.getSmAge()));
            }else{
                sm2.setSmAge(0);
            }
            sm2.setSmHobby(vo2.getSmHobby());
            sm2.setSmName(vo2.getSmName());
            sm2.setSmSex(vo2.getSmSex());
            sm2.setSmAddress(vo2.getSmAddress());
            sm2.setUserTel(vo2.getUserTel());
            sm2.setSmJob(vo2.getSmJob());
            int i = smMapper.insertSelective(sm2);
            if(i>0){
                return new DefaultResult(ResultCode.SUCCESS);
            }
        }else {
            if (vo2.getSmAge() != null) {
                sm1.setSmAge(Integer.parseInt(vo2.getSmAge()));
            } else {
                sm1.setSmAge(0);
            }
            sm1.setSmHobby(vo2.getSmHobby());
            sm1.setSmName(vo2.getSmName());
            sm1.setSmSex(vo2.getSmSex());
            sm1.setSmAddress(vo2.getSmAddress());
            sm1.setUserTel(vo2.getUserTel());
            sm1.setSmJob(vo2.getSmJob());
            return smService.updateByTelephone(sm1);
        }
        return new DefaultResult(ResultCode.SUCCESS);
    }
    @PostMapping("/sm/save")
    @ApiOperation(value = "保存个人信息")
    public Result save(@RequestBody Sm sm){
        return smService.save(sm);
    }
    @PostMapping("/sm/show")
    @ApiOperation(value = "查询个人信息")
    public ResultData selectByTelephone(@RequestBody SmVo3 smVo3){
        return smService.selectByTelephone(smVo3.getUserTel());
    }
    @PostMapping("/sm/weiXinShow")
    @ApiOperation(value = "查询个人信息")
    public ResultData selectBySmName(@RequestBody SmVo vo){
        return smService.selectWeiXinMessage(vo.getSmName());
    }
    @GetMapping("/sm/updateImage")
    @ApiOperation(value = "修改头像")
    public Result updateImage( SmVo4 vo4){
        return smService.updateByUserTel(vo4.getSmImage(),vo4.getUserTel());
    }
    @PostMapping("/sm/weiXinEdit")
    @ApiOperation(value = "微信编辑个人信息")
    public Result updateByWeiXinTelephone(@RequestBody SmVo2 vo2){
        Sm sm1 = smService.selectBySmNameWeiXin(vo2.getSmName());
        if(sm1==null){
            Sm sm2=new Sm();
            //if(vo2.getSmAge()!=null) {
            //    sm2.setSmAge(Integer.parseInt(vo2.getSmAge()));
            //}else{
            //    sm2.setSmAge(0);
            //}
            sm2.setSmHobby(vo2.getSmHobby());
            //sm2.setSmName(vo2.getSmName());
            //sm2.setSmSex(vo2.getSmSex());
            sm2.setSmAddress(vo2.getSmAddress());
            sm2.setUserTel(vo2.getUserTel());
            Mecode mecode = mecodeMapper.selectByUserTel(vo2.getUserTel());
            if(mecode==null){
                return new DefaultResult(ResultCode.FAIL);
            }
            if(!vo2.getNumber().equals(mecode.getNumber())){
                return new DefaultResult(ResultCode.FAIL);
            }
            int i = smMapper.insertSelective(sm2);
            //User user = userMapper.selectByUserTel(sm1.getUserTel());

            if(i>0){
                return new DefaultResult(ResultCode.SUCCESS);
            }
        }else {
            //if (vo2.getSmAge() != null) {
            //    sm1.setSmAge(Integer.parseInt(vo2.getSmAge()));
            //} else {
            //    sm1.setSmAge(0);
            //}
            Mecode mecode = mecodeMapper.selectByUserTel(vo2.getUserTel());
            if(mecode==null){
                return new DefaultResult(ResultCode.FAIL);
            }
            if(!vo2.getNumber().equals(mecode.getNumber())){
                return new DefaultResult(ResultCode.FAIL);
            }
            System.out.println(sm1.getUserTel());
            User user = userMapper.selectByUserTel(sm1.getUserTel());
            System.out.println(user);
            user.setUserTel(vo2.getUserTel());
            int i = userMapper.updateByPrimaryKeySelective(user);
            sm1.setSmHobby(vo2.getSmHobby());
            //sm1.setSmName(vo2.getSmName());
            //sm1.setSmSex(vo2.getSmSex());
            sm1.setSmAddress(vo2.getSmAddress());
            sm1.setUserTel(vo2.getUserTel());
            return smService.updateByTelephone(sm1);
        }
        return new DefaultResult(ResultCode.SUCCESS);
    }
    @GetMapping("/sm/editByLocation")
    @ApiOperation(value = "三级联动修改位置")
    public Result weiXinEditByLocation(SmVo5 vo5){
        Sm sm = smMapper.selectWeiXinMessage(vo5.getSmName());
        if(sm==null){
            return new DefaultResult(ResultCode.FAIL);
        }
        sm.setSmAddress(vo5.getSmAddress());
        int i = smMapper.updateBySmName(sm);
        if(i>0){
            return new DefaultResult(ResultCode.SUCCESS);
        }
        return new DefaultResult(ResultCode.FAIL);
    }
}
