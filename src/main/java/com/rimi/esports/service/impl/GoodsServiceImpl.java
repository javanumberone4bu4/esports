package com.rimi.esports.service.impl;

import com.rimi.esports.beans.Goods;
import com.rimi.esports.common.*;
import com.rimi.esports.mapper.GoodsMapper;
import com.rimi.esports.service.IGoodsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Wang Xiaoping
 * @date 2019/10/30 20:20
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class GoodsServiceImpl implements IGoodsService {
    private GoodsMapper goodsMapper;
    private List list;
    public GoodsServiceImpl(GoodsMapper goodsMapper) {
        this.goodsMapper = goodsMapper;
    }

    /**
     * 查询所有商品
     *
     * @return 商品列表
     */
    @Override
    public ResultData selectAll() {
        List<Goods> goods = goodsMapper.selectAll();
        if(goods!=null&&goods.size()>0){
            return new DefaultResultData(goods);
        }
        return null;
    }

    /**
     * 插入数据
     *
     * @param record 商品对象
     * @return 受影响行数
     */
    @Override
    public Result insertSelective(Goods record) {
        if(record==null){
            return new DefaultResult(ResultCode.FAIL);
        }
        int i = goodsMapper.insertSelective(record);
        if(i>0){
            return new DefaultResult(ResultCode.SUCCESS);
        }
        return new DefaultResult(ResultCode.FAIL);
    }

    @Override
    public ResultData selectByUserTel(String goodsSource) {
        if(goodsSource==null){
            return null;
        }
        Goods goods = goodsMapper.selectByUserTel(goodsSource);
        if(goods!=null){
            list=new ArrayList();
            list.add(goods);
            return new DefaultResultData(list);
        }
        return null;
    }
}
