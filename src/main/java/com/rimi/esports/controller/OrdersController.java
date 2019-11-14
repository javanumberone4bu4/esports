package com.rimi.esports.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.rimi.esports.beans.Orders;
import com.rimi.esports.common.*;
import com.rimi.esports.service.IOrdersService;
import com.rimi.esports.vo.AcquireOrderForm;
import com.rimi.esports.vo.OrdersVo;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Wang Xiaoping
 * @date 2019/11/13 17:08
 */
@RestController
@CrossOrigin
public class OrdersController {
    private IOrdersService ordersService;
    private List list2;
    public OrdersController(IOrdersService ordersService) {
        this.ordersService = ordersService;
    }
    @GetMapping("/orders/editGet")
    @ApiOperation(value = "编辑收货人信息")
    public Result editMessage(OrdersVo vo){
        List<Orders> orders = ordersService.selectByUserTelAndNum(vo.getUserTel(), vo.getOrdersNum());
        if(orders==null){
            return new DefaultResult(ResultCode.FAIL);
        }
        if(orders.size()==1) {
            orders.get(0).setOrdersGetaddress(vo.getOrdersGetaddress());
            orders.get(0).setOrdersGetphone(vo.getOrdersGetphone());
            return ordersService.editAddressAndPhone(orders.get(0));
        }else {
            for (Orders order : orders) {
                order.setOrdersGetaddress(vo.getOrdersGetaddress());
                order.setOrdersGetphone(vo.getOrdersGetphone());
                return ordersService.editAddressAndPhone(order);
            }
        }
        return new DefaultResult(ResultCode.FAIL);
    }
    @GetMapping("/orders/check")
    @ApiOperation(value = "核对订单页面")
    public ResultData checkOrders(OrdersVo vo){
        return ordersService.selectOrdersGoods(vo.getUserTel(),vo.getOrdersNum());
    }
    @GetMapping("/orders/delete")
    @ApiOperation(value = "删除订单")
    public Result deleteOrders(OrdersVo vo){
        return ordersService.deleteOrders(vo.getUserTel(),vo.getOrdersNum());
    }
    @GetMapping("/orders/selectAll")
    @ApiOperation(value = "查询所有订单分类我租的我借的")
   public ResultData selectAllOrders(OrdersVo vo){
        PageHelper.startPage(vo.getPageNumber(),vo.getPageSize());
        List list = ordersService.selectByParams(vo.getUserTel(), vo.getOrdersStatus());
        return new DefaultResultData(PageInfo.of(list));
    }
    @GetMapping("/orders/selectAllByParams")
    @ApiOperation(value = "查询所有订单根据条件")
    public ResultData selectAllOrdersP(OrdersVo vo){
        PageHelper.startPage(vo.getPageNumber(),vo.getPageSize());
        List list = ordersService.selectByParamsCondition(vo.getUserTel(), vo.getOrdersStatus(),vo.getGoodsName());
        return new DefaultResultData(PageInfo.of(list));
    }
    @GetMapping("/orders/getOrders")
    @ApiOperation(value = "生成订单")
    public ResultData getOrders(OrdersVo vo){
        for (int i = 0; i < vo.getGoodsid().length; i++) {
            Orders orders=new Orders();
            orders.setUserTel(vo.getUserTel());
            orders.setGoodsid(Integer.parseInt(vo.getGoodsid()[i]));
            orders.setOrdersNum(new AcquireOrderForm().getOrderForm(vo.getUserTel()));
            int j = ordersService.insertOrders(orders);
        }
        return ordersService.selectAllByUserTel(vo.getUserTel());


    }
    @GetMapping("/orders/returnMessage")
    @ApiOperation(value = "支付成功返回订单信息")
    public ResultData getMessage(OrdersVo vo){
        List list = ordersService.selectByParams(vo.getUserTel(), vo.getOrdersStatus());
        if(list!=null&&list.size()>0){
            return new DefaultResultData(list.get(list.size()-1));
        }
        return null;
    }
}
