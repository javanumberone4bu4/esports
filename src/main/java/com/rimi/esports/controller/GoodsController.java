package com.rimi.esports.controller;

import com.github.pagehelper.PageInfo;
import com.rimi.esports.beans.Goods;
import com.rimi.esports.common.Result;
import com.rimi.esports.common.ResultData;
import com.rimi.esports.service.IGoodsService;
import com.rimi.esports.vo.BrandVo3;
import com.rimi.esports.vo.GoodsVo;
import com.rimi.esports.vo.GoodsVo1;
import com.rimi.esports.vo.GoodsVo2;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

/**
 * 商品服务
 *
 * @author Wang Xiaoping
 * @date 2019/11/8 15:46
 */
@RestController
@CrossOrigin
public class GoodsController {
    private IGoodsService goodsService;

    public GoodsController(IGoodsService goodsService) {
        this.goodsService = goodsService;
    }

    @PostMapping("/goods/save")
    @ApiOperation(value = "微信端保存商品信息")
    public Result save(@RequestBody GoodsVo vo){
        Goods goods=new Goods();
        goods.setGoodsSource(vo.getGoodsSource());
        goods.setGoodsPhoto(vo.getGoodsPhoto());
        goods.setGoodsLocation(vo.getGoodsLocation());
        goods.setGoodsDescription(vo.getGoodsDescription());
        goods.setGoodsClassify(vo.getGoodsClassify());
        goods.setGoodsPrice(vo.getGoodsPrice());
        goods.setGoodsNum(vo.getGoodsNum());
        goods.setGoodsPricesum(vo.getGoodsPrice()*vo.getGoodsNum());
        return goodsService.insertSelective(goods);
    }
    @PostMapping("/goods/show")
    @ApiOperation(value = "微信端查看商品信息")
    public ResultData show(@RequestBody GoodsVo1 vo1){
        return goodsService.selectByUserTel(vo1.getGoodsSource());
    }
    @GetMapping("/goods/selectAll")
    @ApiOperation(value = "查询所有商品")
    public ResultData selectAll(){
       return  goodsService.selectAll();
    }
    @GetMapping("/goods/guessLike")
    @ApiOperation(value = "猜你喜欢数据")
    public ResultData guessLike(){

        return goodsService.guessLike();
    }
    @GetMapping("/goods/selectById")
    @ApiOperation(value = "根据ID查询商品详情")
    public ResultData selectById(GoodsVo2 vo2){

       return goodsService.selectByPrimaryKey(vo2.getGoodsId());
    }
    @GetMapping("/goods/selectPcGoods")
    @ApiOperation(value = "根据品牌类型名字查找相应的商品")
    public ResultData selectPcGoods(BrandVo3 vo3){
        return goodsService.selectPcGoods(vo3.getBrandLogoname());
    }
}