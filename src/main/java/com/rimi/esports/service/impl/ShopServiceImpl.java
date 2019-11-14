package com.rimi.esports.service.impl;

import com.rimi.esports.beans.Shop;
import com.rimi.esports.common.*;
import com.rimi.esports.mapper.ShopMapper;
import com.rimi.esports.service.IShopService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Wang Xiaoping
 * @date 2019/10/30 20:18
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class ShopServiceImpl implements IShopService {
    private ShopMapper shopMapper;

    public ShopServiceImpl(ShopMapper shopMapper) {
        this.shopMapper = shopMapper;
    }

    @Override
    public ResultData selectGoods(String userTel) {
        List list = shopMapper.selectGoodsByShop(userTel);
        if(list!=null&&list.size()>0){
            return new DefaultResultData(list);
        }
        return null;
    }

    @Override
    public Result insertShopCar(Shop shop) {
        int i = shopMapper.insertSelective(shop);
        if(i>0){
            return new DefaultResult(ResultCode.SUCCESS);
        }
        return new DefaultResult(ResultCode.FAIL);
    }

    @Override
    public Result deleteByGoodsId(Integer goodsId,String userTel) {
        int i = shopMapper.deleteByGoods(goodsId,userTel);
        if(i>0){
            return new DefaultResult(ResultCode.SUCCESS);
        }
        return new DefaultResult(ResultCode.FAIL);
    }

    @Override
    public Result deleteByIds(String[] ids,String userTel) {
        for (String id : ids) {
            deleteByGoodsId(Integer.valueOf(id), userTel);
        }
        return new DefaultResult(ResultCode.SUCCESS);
    }

    @Override
    public Result deleteWeixin(List<String> ids2, String userTel) {
        for (String s : ids2) {
            deleteByGoodsId(Integer.valueOf(s),userTel);
        }
        return new DefaultResult(ResultCode.SUCCESS);
    }

    @Override
    public Shop selectByGoodsIdAndUserTel(Integer goodsId,String userTel) {
        Shop shop = shopMapper.selectByGoodsIdAndUserTel(goodsId,userTel);
        if(shop!=null){
            return shop;
        }
        return null;
    }

    @Override
    public Result updateByPrimaryKeySelective(Shop shop) {
        int i = shopMapper.updateByPrimaryKeySelective(shop);
        if(i>0){
            return new DefaultResult(ResultCode.SUCCESS);
        }
        return new DefaultResult(ResultCode.FAIL);
    }
}
