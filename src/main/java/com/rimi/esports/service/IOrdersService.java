package com.rimi.esports.service;

import com.rimi.esports.beans.Orders;
import com.rimi.esports.common.Result;
import com.rimi.esports.common.ResultData;

import java.util.List;

/**
 * @author Wang Xiaoping
 * @date 2019/10/30 20:19
 */

public interface IOrdersService {
    Result editAddressAndPhone(Orders orders);

    List<Orders> selectByUserTelAndNum(String userTel,String ordersNum);

    ResultData selectOrdersGoods(String userTel,String ordersNum);

    Result deleteOrders(String userTel,String ordersNum);

    List selectByParams(String userTel, String ordersStatus);

    List selectByParamsCondition(String userTel,String ordersStatus,String goodsName);

    int insertOrders(Orders orders);

    ResultData selectAllByUserTel(String userTel);

    //List<Orders> selectByUserTelAndNum2(String userTel,String ordersNum);
}
