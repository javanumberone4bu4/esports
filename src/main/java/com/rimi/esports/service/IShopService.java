package com.rimi.esports.service;

import com.rimi.esports.beans.Shop;
import com.rimi.esports.common.Result;
import com.rimi.esports.common.ResultData;

import java.util.List;

/**
 * @author Wang Xiaoping
 * @date 2019/10/30 20:18
 */
public interface IShopService {
    ResultData selectGoods(String userTel);

    Result insertShopCar(Shop shop);

    Result deleteByGoodsId(Integer goodsId,String userTel);

    Shop selectByGoodsIdAndUserTel(Integer goodsId,String userTel);

    Result updateByPrimaryKeySelective(Shop shop);

    Result deleteByIds(String[] ids,String userTel);

    Result deleteWeixin(List<String> ids2,String userTel);
}
