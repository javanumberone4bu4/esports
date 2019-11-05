package com.rimi.esports.service.impl;

import com.aliyuncs.exceptions.ClientException;
import com.rimi.esports.beans.User;
import com.rimi.esports.common.*;
import com.rimi.esports.mapper.UserMapper;
import com.rimi.esports.service.IUserService;
import com.rimi.esports.util.SendMessageUtils;
import com.rimi.esports.vo.UserVo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Wang Xiaoping
 * @date 2019/10/30 20:17
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl implements IUserService {
    private List list;
    private  UserMapper userMapper;
    private int num=(int)(Math.random()*900000+100000);

    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public Result selectByUserTel(String userTel) {
        User user = userMapper.selectByUserTel(userTel);
        if(user!=null){
            return new DefaultResult(ResultCode.FAIL);
        }
        return new DefaultResult(ResultCode.SUCCESS);
    }


    @Override
    public ResultData insert(User user, String number) {
        //Date date=new Date();
        //String date1 = new SimpleDateFormat().format(date);
        //int num=(int)(Math.random()*900000+100000);
        try {
            SendMessageUtils.sendMessage(user.getUserTel(),String.valueOf(num));
        } catch (ClientException e) {
            e.printStackTrace();
        }
        if(Integer.parseInt(number)==num) {
            int insert = userMapper.insertSelective(user);
            if (insert > 0) {
                list=new ArrayList();
                list.add(user);
                list.add(num);
                return new DefaultResultData(list);
            }else{
                list=new ArrayList();
                list.add(user);
                list.add(num);
                return new DefaultResultData(list);
            }
        }
        list=new ArrayList();
        list.add(user);
        list.add(num);
        return new DefaultResultData(list);
    }

    @Override
    public ResultData selectByUserTelAndPassword(UserVo vo) {
        User user = userMapper.selectByUserTelAndPassword(vo.getUserTel(), vo.getPassword());
        if(user!=null){
            list=new ArrayList();
            list.add(vo);
            return new DefaultResultData(vo);
        }
     list=new ArrayList();
        list.add(vo);
        return new DefaultResultData(vo);
    }

    @Override
    public ResultData findPassword(UserVo vo, String number) {
        //Date date=new Date();
        //String date1 = new SimpleDateFormat().format(date);
        //int num=(int) (Math.random()*900000+100000);
        try {
            SendMessageUtils.sendMessage(vo.getUserTel(),String.valueOf(num));
        } catch (ClientException e) {
            e.printStackTrace();
        }
        if(num==Integer.parseInt(number)) {
            int i = userMapper.updatePassword(vo.getUserTel(), vo.getPassword());
            if (i > 0) {
                list=new ArrayList();
                list.add(vo);
                list.add(num);
                return new DefaultResultData(list);
            }else {
                list=new ArrayList();
                list.add(vo);
                list.add(num);
                return new DefaultResultData(list);
            }
        }
        list=new ArrayList();
        list.add(vo);
        list.add(num);
        return new DefaultResultData(list);
    }

    @Override
    public Result updatePassword(UserVo vo) {
        int i = userMapper.updatePassword(vo.getUserTel(), vo.getPassword());
        if(i>0){
            return new DefaultResult(ResultCode.SUCCESS);
        }
        return new DefaultResult((ResultCode.FAIL));
    }

    @Override
    public Result updateUserMoney(String sourceUserTel, String targetUserTel, BigDecimal userMoney) {
        // 1.查询转出账号
        User user = userMapper.selectByUserTel(sourceUserTel);
        if (user == null) {
            return new DefaultResult(ResultCode.FAIL);
        }
        // 2.查询转入账号
        User user1 = userMapper.selectByUserTel(targetUserTel);
        if (user1 == null) {
            return new DefaultResult(ResultCode.FAIL);
        }
        // 3.转出账号减钱
        if (user.getUserMoney().doubleValue() < userMoney.doubleValue()) {
            return new DefaultResult(ResultCode.FAIL);
        }
        user.setUserMoney(user.getUserMoney().subtract(userMoney));
        // 4.转入账号加钱
        user1.setUserMoney(user1.getUserMoney().add(userMoney));
        // 5.更新转入账号
        userMapper.updateUserMoney(user1);

        //int i = 1 / 0;

        // 6.更新转出账号
        userMapper.updateUserMoney(user);
        return new DefaultResult(ResultCode.SUCCESS);
    }

    @Override
    public ResultData getNum(String telephone) {
        try {
            SendMessageUtils.sendMessage(telephone,String.valueOf(num));
        } catch (ClientException e) {
            e.printStackTrace();
        }
      list=new ArrayList();
        list.add(String.valueOf(num));
        return new DefaultResultData(list);
    }
}
