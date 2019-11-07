package com.rimi.esports.mapper;

import com.rimi.esports.beans.Goods;

/**
 * ${Description}
 *
 * @author Wang Xiaoping
 * @date 2019/11/6 14:30
 */
public interface GoodsMapper {
    int deleteByPrimaryKey(Integer goodsId);

    int insert(Goods record);

    int insertSelective(Goods record);

    Goods selectByPrimaryKey(Integer goodsId);

    int updateByPrimaryKeySelective(Goods record);

    int updateByPrimaryKey(Goods record);
}