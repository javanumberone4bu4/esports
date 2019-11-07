package com.rimi.esports.util;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Wang Xiaoping
 * @date 2019/11/6 21:22
 */
public class PwdUtilsTest {

    @Test
    public void getPwd() {
        String password="18780811904123";
        String pwd = PwdUtils.getPwd(password);
        System.out.println(pwd);
        String password1="13438557479123";
        String pwd1 = PwdUtils.getPwd(password1);
        System.out.println(pwd1);
        String password3="17628150802123456789";
        System.out.println(PwdUtils.getPwd(password3));
        System.out.println(PwdUtils.getPwd("18284335838123456"));
        System.out.println(PwdUtils.getPwd("18161326552123"));
        System.out.println(PwdUtils.getPwd("10"));
    }
}