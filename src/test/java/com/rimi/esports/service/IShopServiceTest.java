package com.rimi.esports.service;

import com.rimi.esports.common.ResultData;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * @author Wang Xiaoping
 * @date 2019/11/11 15:47
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:config/spring/spring-service.xml"})
public class IShopServiceTest {
    @Autowired
   private IShopService shopService;
    @Test
    public void selectGoods() {
        ResultData resultData = shopService.selectGoods("18780811904");
        System.out.println(resultData);
    }
}