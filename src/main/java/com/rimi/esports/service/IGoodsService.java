package com.rimi.esports.service;


import com.rimi.esports.beans.Goods;
import com.rimi.esports.common.Result;
import com.rimi.esports.common.ResultData;

/**
 * @author Wang Xiaoping
 * @date 2019/10/30 20:20
 */
public interface IGoodsService {
    /**
     * 查询所有商品
     * @return 商品列表
     */
    ResultData selectAll();

    /**
     * 插入数据
     * @param record 商品对象
     * @return 受影响行数
     */
    Result insertSelective(Goods record);


    ResultData selectByUserTel(String goodsSource);

    ResultData guessLike();

}
