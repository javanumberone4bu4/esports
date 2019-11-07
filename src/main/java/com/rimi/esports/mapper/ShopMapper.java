package com.rimi.esports.mapper;

import com.rimi.esports.beans.Shop;

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
}