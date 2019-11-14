package com.rimi.esports.service.impl;

import com.github.pagehelper.PageHelper;
import com.rimi.esports.beans.Orders;
import com.rimi.esports.common.*;
import com.rimi.esports.mapper.OrdersMapper;
import com.rimi.esports.service.IOrdersService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Wang Xiaoping
 * @date 2019/10/30 20:19
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class OrdersServiceImpl implements IOrdersService {
    private OrdersMapper ordersMapper;

    public OrdersServiceImpl(OrdersMapper ordersMapper) {
        this.ordersMapper = ordersMapper;
    }

    @Override
    public Result editAddressAndPhone(Orders orders) {
        if(orders==null){
            return new DefaultResult(ResultCode.FAIL);
        }
        int i = ordersMapper.updateByPrimaryKeySelective(orders);
        if(i>0){
            return new DefaultResult(ResultCode.SUCCESS);
        }
        return new DefaultResult(ResultCode.FAIL);
    }

    @Override
    public List<Orders> selectByUserTelAndNum(String userTel, String ordersNum) {
        List<Orders> orders = ordersMapper.selectByUserTelAndNum(userTel, ordersNum);

        if(orders!=null&&orders.size()>0){
            return orders;
        }
        return null;
    }

    @Override
    public ResultData selectOrdersGoods(String userTel, String ordersNum) {
        List list = ordersMapper.selectOrdersGoods(userTel, ordersNum);
        if(list!=null&&list.size()>0){
            return new DefaultResultData(list);
        }
        return null;
    }

    @Override
    public Result deleteOrders(String userTel, String ordersNum) {
        int i = ordersMapper.deleteByParam(userTel, ordersNum);
        if(i>0){
            return new DefaultResult(ResultCode.SUCCESS);
        }
        return new DefaultResult(ResultCode.FAIL);
    }

    @Override
    public List selectByParams(String userTel, String ordersStatus) {
       // PageHelper.startPage(1,1);
        List list = ordersMapper.selectOrdersGoodsBy(userTel, ordersStatus);
        if(list!=null&&list.size()>0){
            return list;
        }
        return null;
    }

    @Override
    public List selectByParamsCondition(String userTel, String ordersStatus, String goodsName) {
        List list = ordersMapper.selectOrdersGoodsByCondition(userTel, ordersStatus, goodsName);
        if(list!=null&&list.size()>0){
            return list;
        }
        return null;
    }

    @Override
    public int insertOrders(Orders orders) {
        if(orders==null){
            return 0;
        }
        int i = ordersMapper.insertSelective(orders);
        if(i>0){
            return i;
        }
        return 0;
    }

    @Override
    public ResultData selectAllByUserTel(String userTel) {
        if(userTel==null){
            return null;
        }
        List<Orders> orders = ordersMapper.selectAllBy(userTel);
        if(orders!=null&&orders.size()>0){
            return new DefaultResultData(orders);
        }
        return null;
    }
}
