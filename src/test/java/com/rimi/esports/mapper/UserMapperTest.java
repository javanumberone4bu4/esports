package com.rimi.esports.mapper;

import com.rimi.esports.beans.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * @author Wang Xiaoping
 * @date 2019/11/3 11:34
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:config/spring/spring-mybatis.xml"})
public class UserMapperTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void selectByUserTel() {
        User user = userMapper.selectByUserTel("18780811904");
        System.out.println(user);
    }

    @Test
    public void insert() {
        User user=new User();
        user.setUserTel("18780811904");
        user.setPassword("123");
        int insert = userMapper.insert(user);
        Assert.assertEquals(1,insert);

    }
}