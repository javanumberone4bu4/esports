package com.rimi.esports.mapper;

import com.rimi.esports.beans.Goods;

import java.util.List;

/**
 * ${Description}
 * @author Wang Xiaoping
 * @date 2019/11/10 14:58
 */
public interface GoodsMapper {
    int deleteByPrimaryKey(Integer goodsId);

    int insert(Goods record);

    int insertSelective(Goods record);

    Goods selectByPrimaryKey(Integer goodsId);

    int updateByPrimaryKeySelective(Goods record);

    int updateByPrimaryKey(Goods record);

    List<Goods> selectAll();

    Goods selectByUserTel(String goodsSource);

    List<Goods> selectByParam();

    List selectPcGoods(String brandLogoname);




}