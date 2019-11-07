package com.rimi.esports.mapper;

import com.rimi.esports.beans.User;
import org.apache.ibatis.annotations.Param;

/**
 * ${Description}
 * @author Wang Xiaoping
 * @date 2019/11/7 22:35
 */
public interface UserMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    /**
     *   注册时需要的方法(查询账号是否存在)
     */
    User selectByUserTel(String userTel);

    /**
     * 注册成功保存数据
     * @return 受影响行数
     */
   // int insertSelective(User user);

    /**
     * 登录时判断账号密码是否正确
     * @param userTel 用户名
     * @param password 密码
     * @return 用户对象
     */
    User selectByUserTelAndPassword(@Param("userTel") String userTel, @Param("password") String password);

    /**
     * 修改密码
     * @param userTel 用户名
     * @param password 密码
     * @return 受影响行数
     */
    int updatePassword(@Param("userTel") String userTel,@Param("password") String password);

    /**
     * 支付
     * @param user 支付对象
     * @return 受影响行数
     */
    int updateUserMoney(User user);

    User selectByOpenId(String openId);
}