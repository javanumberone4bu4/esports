package com.rimi.esports.controller;

import com.rimi.esports.beans.Goods;
import com.rimi.esports.common.Result;
import com.rimi.esports.common.ResultData;
import com.rimi.esports.service.IGoodsService;
import com.rimi.esports.vo.GoodsVo;
import com.rimi.esports.vo.GoodsVo1;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
        goods.setGoodsPricesum(vo.getGoodsPricesum());
        return goodsService.insertSelective(goods);
    }
    @PostMapping("/goods/show")
    @ApiOperation(value = "微信端查看商品信息")
    public ResultData show(@RequestBody GoodsVo1 vo1){
        return goodsService.selectByUserTel(vo1.getGoodsSource());
    }
}
