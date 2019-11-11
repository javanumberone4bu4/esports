package com.rimi.esports.controller;

import com.rimi.esports.common.ResultData;
import com.rimi.esports.service.ICommonCityService;
import com.rimi.esports.vo.CommonCityVo;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Wang Xiaoping
 * @date 2019/11/11 14:13
 */
@RestController
@CrossOrigin
public class CommonCityController {
    private ICommonCityService commonCityService;

    public CommonCityController(ICommonCityService commonCityService) {
        this.commonCityService = commonCityService;
    }
    @GetMapping("/commonCity/selectByLocation")
    @ApiOperation(value = "通过位置查询所有信息")
    public ResultData selectByLocation( CommonCityVo vo){
        return commonCityService.selectByLocation(vo.getCommoncityLocation());
    }
}
