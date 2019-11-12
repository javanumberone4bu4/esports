package com.rimi.esports.mapper;

import com.rimi.esports.beans.Orders;

/**
 * ${Description}
 *
 * @author Wang Xiaoping
 * @date 2019/11/6 14:29
 */
public interface OrdersMapper {
    int deleteByPrimaryKey(Integer ordersId);

    int insert(Orders record);

    int insertSelective(Orders record);

    Orders selectByPrimaryKey(Integer ordersId);

    int updateByPrimaryKeySelective(Orders record);

    int updateByPrimaryKey(Orders record);


}