package com.rimi.esports.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author Wang Xiaoping
 * @date 2019/11/11 15:52
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:config/spring/spring-mybatis.xml"})
public class ShopMapperTest {
    @Autowired
   private ShopMapper shopMapper;
    @Test
    public void selectGoodsByShop() {
        List list = shopMapper.selectGoodsByShop("18780811904");
        System.out.println(list);
    }
}