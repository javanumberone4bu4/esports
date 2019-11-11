package com.rimi.esports.service.impl;

import com.rimi.esports.common.DefaultResultData;
import com.rimi.esports.common.ResultData;
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
}
