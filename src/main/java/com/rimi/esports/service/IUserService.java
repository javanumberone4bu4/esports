package com.rimi.esports.service;

import com.rimi.esports.beans.Sm;
import com.rimi.esports.beans.User;
import com.rimi.esports.common.Result;
import com.rimi.esports.common.ResultData;
import com.rimi.esports.vo.UserVo;
import com.rimi.esports.vo.UserVo4;


import java.math.BigDecimal;

/**
 * @author Wang Xiaoping
 * @date 2019/10/30 20:17
 */
public interface IUserService {
    Result selectByUserTel(String userTel);
    Result insert(User user,String number);
    Result getNum(String telephone);
    Result selectByUserTelAndPassword(User user);
    Result updatePassword(User user);
    Result findPassword(User user,String number);
    Result updateUserMoney(String sourceUserTel, String targetUserTel, BigDecimal userMoney);
    Result weiXinLogin(String openId, Sm sm);
    User selectByUserTel2(String userTel);

}
