package com.rimi.esports.mapper;

import com.rimi.esports.beans.Shop;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * ${Description}
 *
 * @author Wang Xiaoping
 * @date 2019/11/6 14:29
 */
public interface ShopMapper {
    int deleteByPrimaryKey(Integer shopId);

    int insert(Shop record);

    int insertSelective(Shop record);

    Shop selectByPrimaryKey(Integer shopId);

    int updateByPrimaryKeySelective(Shop record);

    int updateByPrimaryKey(Shop record);

    List selectGoodsByShop(String userTel);

    int deleteByGoods(@Param("goodsId") Integer goodsId,@Param("userTel") String userTel);

    Shop selectByGoodsIdAndUserTel(@Param("goodsId") Integer goodsId,@Param("userTel") String userTel);
}