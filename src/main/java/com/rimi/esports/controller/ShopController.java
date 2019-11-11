package com.rimi.esports.controller;

import com.rimi.esports.common.ResultData;
import com.rimi.esports.service.IShopService;
import com.rimi.esports.vo.ShopVo;
import org.springframework.web.bind.annotation.*;

/**
 * @author Wang Xiaoping
 * @date 2019/11/11 16:09
 */
@RestController
@CrossOrigin
public class ShopController {
    private IShopService shopService;

    public ShopController(IShopService shopService) {
        this.shopService = shopService;
    }
    @GetMapping("/shop/selectGoods")
    public ResultData selectGoods( ShopVo vo){
     return shopService.selectGoods(vo.getUserTel());
    }
}
