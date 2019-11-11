package com.rimi.esports.controller;

import com.rimi.esports.beans.Brand;
import com.rimi.esports.common.DefaultResult;
import com.rimi.esports.common.Result;
import com.rimi.esports.common.ResultCode;
import com.rimi.esports.common.ResultData;
import com.rimi.esports.service.IBrandService;
import com.rimi.esports.vo.BrandVo1;
import com.rimi.esports.vo.BrandVo2;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

/**
 * 品牌交互层
 *
 * @author Wang Xiaoping
 * @date 2019/11/10 11:55
 */
@RestController
@CrossOrigin
public class BrandController {
    private IBrandService brandService;

    public BrandController(IBrandService brandService) {
        this.brandService = brandService;
    }
    @PostMapping("/brand/insert")
    @ApiOperation(value = "品牌插入数据")
    public Result insert(@RequestBody Brand brand){
        if(brand==null){
            return new DefaultResult(ResultCode.FAIL);
        }
      return  brandService.insertSelective(brand);
    }
    @PostMapping("/brand/selectByBrandType")
    @ApiOperation(value = "通过品牌类型查询数据")
    public ResultData selectByBrandType(@RequestBody BrandVo1 vo1){
        if(vo1==null){
            return null;
        }
       return brandService.selectByBrandType(vo1.getBrandType());
    }
    @PostMapping("/brand/selectByNameAndType")
    @ApiOperation(value = "查询品牌名字和类型")
    public ResultData selectByBrandNameAndBrandType(){

        return brandService.selectByBrandNameAndBrandType();
    }
    @GetMapping("brand/selectByParam")
    public ResultData selectByNameAndTypeAndLogoName(){
        return brandService.selectByNameAndTypeAndLogoName();


    }
    @GetMapping("/brand/default")
    public ResultData selectByParam(){
        return brandService.selectByParam();

    }
    @GetMapping("/brand/classify")
    public ResultData selectByCondition(BrandVo2 vo2){
      return brandService.selectByCondition(vo2.getBrandType(),vo2.getBrandName());
    }
}
