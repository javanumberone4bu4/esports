package com.rimi.esports.controller;

import com.rimi.esports.beans.Sm;
import com.rimi.esports.common.Result;
import com.rimi.esports.common.ResultData;
import com.rimi.esports.service.ISmService;
import com.rimi.esports.vo.SmVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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

    public SmController(ISmService smService) {
        this.smService = smService;
    }
    @PostMapping("/sm/edit")
    @ApiOperation(value = "编辑个人信息")
    public Result updateByTelephone(@RequestBody Sm sm){
        return smService.updateByTelephone(sm);
    }
    @PostMapping("/sm/save")
    @ApiOperation(value = "保存个人信息")
    public Result save(@RequestBody Sm sm){
        return smService.save(sm);
    }
    @PostMapping("/sm/show")
    @ApiOperation(value = "查询个人信息")
    public ResultData selectByTelephone(@RequestBody Sm sm){
        return smService.selectByTelephone(sm);
    }
    @PostMapping("/sm/weiXinShow")
    @ApiOperation(value = "查询个人信息")
    public ResultData selectBySmName(@RequestBody SmVo vo){
        return smService.selectBySmName(vo.getSmName());
    }
}
