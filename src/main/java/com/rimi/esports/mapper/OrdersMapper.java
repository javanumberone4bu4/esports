package com.rimi.esports.mapper;

import com.rimi.esports.beans.Orders;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * ${Description}
 * @author Wang Xiaoping
 * @date 2019/11/13 16:02
 */
public interface OrdersMapper {
    int deleteByPrimaryKey(Integer ordersId);

    int insert(Orders record);

    int insertSelective(Orders record);

    Orders selectByPrimaryKey(Integer ordersId);

    int updateByPrimaryKeySelective(Orders record);

    int updateByPrimaryKey(Orders record);

    List<Orders> selectByUserTelAndNum(@Param("userTel") String userTel, @Param("ordersNum") String ordersNum);

    List selectOrdersGoods(@Param("userTel") String userTel, @Param("ordersNum") String ordersNum);

    int deleteByParam(@Param("userTel") String userTel, @Param("ordersNum") String ordersNum);

    List selectOrdersGoodsBy(@Param("userTel") String userTel,@Param("ordersStatus")String ordersStatus);

    List selectOrdersGoodsByCondition(@Param("userTel") String userTel,@Param("ordersStatus")String ordersStatus,@Param("goodsName")String goodsName);

    List<Orders> selectAllBy(String userTel);

    //List<Orders> selectByUserTelAndNum2(String userTel,String ordersNum);
}