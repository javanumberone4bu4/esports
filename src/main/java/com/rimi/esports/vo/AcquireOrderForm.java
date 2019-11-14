package com.rimi.esports.vo;

/**
 * @author Wang Xiaoping
 * @date 2019/11/13 23:09
 */
public class AcquireOrderForm {

    /**
     * 生成订单
     * @return 订单编号
     */
    public String getOrderForm(String userTel){
        long l = System.currentTimeMillis();
        String s = String.valueOf(l).substring(0,8);
        String substring = userTel.substring(7);
        String newString=s+substring;
        return newString;
    }

    public static void main(String[] args) {
        String orderForm = new AcquireOrderForm().getOrderForm("18780811904");
        System.out.println(orderForm);
        //1573696797851904
        //15736971904
        //157369721904
        //157369731904
    }
}
