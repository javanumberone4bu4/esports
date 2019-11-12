package com.rimi.esports.controller;

import com.rimi.esports.beans.Goods;
import com.rimi.esports.beans.Shop;
import com.rimi.esports.common.DefaultResult;
import com.rimi.esports.common.Result;
import com.rimi.esports.common.ResultCode;
import com.rimi.esports.common.ResultData;
import com.rimi.esports.mapper.GoodsMapper;
import com.rimi.esports.service.IShopService;
import com.rimi.esports.vo.ShopVo;
import com.rimi.esports.vo.ShopVo1;
import com.rimi.esports.vo.ShopVo2;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author Wang Xiaoping
 * @date 2019/11/11 16:09
 */
@RestController
@CrossOrigin
public class ShopController {
    private IShopService shopService;
    @Autowired
    private GoodsMapper goodsMapper;
    public ShopController(IShopService shopService) {
        this.shopService = shopService;
    }
    @GetMapping("/shop/selectGoods")
    public ResultData selectGoods( ShopVo vo){

     return shopService.selectGoods(vo.getUserTel());
    }
    @GetMapping("/shop/insertShopCar")
    public Result insertShopCar(ShopVo1 vo1){
        Shop shop1 = shopService.selectByGoodsIdAndUserTel(Integer.parseInt(vo1.getGoodsId()),vo1.getUserTel());
        if(shop1!=null){
            Goods goods = goodsMapper.selectByPrimaryKey(Integer.parseInt(vo1.getGoodsId()));
            goods.setGoodsNum(goods.getGoodsNum()+Integer.parseInt(vo1.getShopGoodsnum()));
            int i = goodsMapper.updateByPrimaryKeySelective(goods);
            if(i>0){
                return new DefaultResult(ResultCode.SUCCESS);
            }
            return new DefaultResult(ResultCode.FAIL);
        }
        Shop shop=new Shop();
        shop.setGoodsId(Integer.parseInt(vo1.getGoodsId()));
        shop.setUserTel(vo1.getUserTel());

        shop.setShopGoodsnum(Integer.parseInt(vo1.getShopGoodsnum()));
       return shopService.insertShopCar(shop);
    }
    @GetMapping("/shop/deleteByGoodsId")
    @ApiOperation(value = "单个删除")
    public Result deleteByGoodsId(ShopVo1 vo1){
       return shopService.deleteByGoodsId(Integer.parseInt(vo1.getGoodsId()),vo1.getUserTel());
    }
    @GetMapping("/shop/deleteByIds")
    @ApiOperation(value = "批量删除")
    public Result deleteByIds(ShopVo2 vo2){
        return shopService.deleteByIds(vo2.getIds(), vo2.getUserTel());
    }
    @GetMapping("/shop/updateByGoodsId")
    public Result updateByPrimaryKeySelective(ShopVo1 vo1){
        Shop shop = shopService.selectByGoodsIdAndUserTel(Integer.parseInt(vo1.getGoodsId()),vo1.getUserTel());
        if(shop==null){
            return new DefaultResult(ResultCode.FAIL);
        }
        Goods goods = goodsMapper.selectByPrimaryKey(Integer.parseInt(vo1.getGoodsId()));
        goods.setGoodsNum(Integer.parseInt(vo1.getShopGoodsnum()));
        //shop.setShopGoodsnum(Integer.parseInt(vo1.getShopGoodsnum()));
        //return shopService.updateByPrimaryKeySelective(shop);
        int i = goodsMapper.updateByPrimaryKeySelective(goods);
        if(i>0){
            return new DefaultResult(ResultCode.SUCCESS);
        }
        return new DefaultResult(ResultCode.FAIL);
    }
}
