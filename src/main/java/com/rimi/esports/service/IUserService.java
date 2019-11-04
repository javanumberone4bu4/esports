package com.rimi.esports.service;

import com.rimi.esports.beans.User;
import com.rimi.esports.common.Result;
import com.rimi.esports.vo.UserVo;


import java.math.BigDecimal;

/**
 * @author Wang Xiaoping
 * @date 2019/10/30 20:17
 */
public interface IUserService {
    Result selectByUserTel(String userTel);
    Result insert(User user,String number);
    Result selectByUserTelAndPassword(UserVo vo);
    Result updatePassword(UserVo vo);
    Result findPassword(UserVo vo,String number);
    Result updateUserMoney(String sourceUserTel, String targetUserTel, BigDecimal userMoney);
}
