package com.rimi.esports.service.impl;

import com.aliyuncs.exceptions.ClientException;
import com.rimi.esports.beans.Mecode;
import com.rimi.esports.beans.Sm;
import com.rimi.esports.beans.User;
import com.rimi.esports.common.*;
import com.rimi.esports.mapper.MecodeMapper;
import com.rimi.esports.mapper.SmMapper;
import com.rimi.esports.mapper.UserMapper;
import com.rimi.esports.service.IUserService;
import com.rimi.esports.util.PwdUtils;
import com.rimi.esports.util.SendMessageUtils;
import com.rimi.esports.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.SessionAttributes;

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
    //private String num ;
    @Autowired
    private SmMapper smMapper;
    @Autowired
    private MecodeMapper mecodeMapper;
   private int b=0;

    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public Result selectByUserTel(String userTel) {
        if(userTel==null){
            return new DefaultResult(ResultCode.FAIL);
        }
        User user = userMapper.selectByUserTel(userTel);
        if(user!=null){
            return new DefaultResult(ResultCode.FAIL);
        }
        return new DefaultResult(ResultCode.SUCCESS);
    }


    @Override
    public Result insert(User user, String number) {
        //Date date=new Date();
        //String date1 = new SimpleDateFormat().format(date);
        //int num=(int)(Math.random()*900000+100000);
        //try {
        //    SendMessageUtils.sendMessage(user.getUserTel(),String.valueOf(num));
        //} catch (ClientException e) {
        //    e.printStackTrace();
        //}
       // if(num!=null) {
            //if (num.equals(number)) {
        if(user==null){
            return new DefaultResult(ResultCode.FAIL);
        }

        int insert = userMapper.insertSelective(user);
                if (insert > 0) {
                    //list=new ArrayList();
                    //list.add(user);
                    //list.add(num);
                    return new DefaultResult(ResultCode.SUCCESS);
                }
           // }
      //  }
        //list=new ArrayList();
        //list.add(user);
        //list.add(num);
        return new DefaultResult(ResultCode.FAIL);
    }

    @Override
    public Result selectByUserTelAndPassword(User user) {
        User user1 = userMapper.selectByUserTelAndPassword(user.getUserTel(), PwdUtils.getPwd(user.getUserTel() + user.getPassword()));
        if(user1!=null){
            //list=new ArrayList();
            //list.add(user);
            return new DefaultResult(ResultCode.SUCCESS);
        }
      //list=new ArrayList();
      //  list.add(user);
        return new DefaultResult(ResultCode.FAIL);
    }

    @Override
    public User selectByUserTel2(String userTel) {
        if(userTel==null){
            return null;
        }
        return userMapper.selectByUserTel(userTel);
    }

    @Override
    public Result findPassword(User user, String number) {
        //Date date=new Date();
        //String date1 = new SimpleDateFormat().format(date);
        //int num=(int) (Math.random()*900000+100000);
        //try {
        //    SendMessageUtils.sendMessage(user.getUserTel(),String.valueOf(num));
        //} catch (ClientException e) {
        //    e.printStackTrace();
        //}
        if(user==null){
            return new DefaultResult(ResultCode.FAIL);
        }
        User user1 = userMapper.selectByUserTel(user.getUserTel());
        if(user1!=null) {
           // if (num != null) {
               // if (num.equals(number)) {
                    int i = userMapper.updatePassword(user.getUserTel(), PwdUtils.getPwd(user.getUserTel() + user.getPassword()));
                    if (i > 0) {
                        //list=new ArrayList();
                        //list.add(vo);
                        //list.add(num);
                        return new DefaultResult(ResultCode.SUCCESS);
                    }
               // }
           // }
        }
        //list=new ArrayList();
        //list.add(vo);
        //list.add(num);
        return new DefaultResult(ResultCode.FAIL);
    }

    @Override
    public Result updatePassword(User user) {
        if(user==null){
            return new DefaultResult(ResultCode.FAIL);
        }
        int i = userMapper.updatePassword(user.getUserTel(), PwdUtils.getPwd(user.getUserTel() + user.getPassword()));
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

        // int i = 1 / 0;

        // 6.更新转出账号
        userMapper.updateUserMoney(user);
        return new DefaultResult(ResultCode.SUCCESS);
    }

    @Override
    public Result getNum(String telephone) {
        try {
            if(telephone==null){
                return new DefaultResult(ResultCode.FAIL);
            }
            String num = SendMessageUtils.sendMessage(telephone);
            Mecode mecode1 = mecodeMapper.selectByUserTel(telephone);
                if (num != null) {
                    if(mecode1==null) {
                        Mecode mecode = new Mecode();
                        mecode.setUsertel(telephone);
                        mecode.setNumber(num);
                        int i = mecodeMapper.insertSelective(mecode);
                    }else{
                        int i = mecodeMapper.updateByUserTel(num, telephone);
                    }
                }else {
                    return new DefaultResult(ResultCode.FAIL);
                }


        } catch (ClientException e) {
            e.printStackTrace();
            return new DefaultResult(ResultCode.FAIL);
        }
        return new DefaultResult(ResultCode.SUCCESS);
    }

    @Override
    public Result weiXinLogin(String openId, Sm sm) {
        b=b+1;
        User user = userMapper.selectByOpenId(openId);
        if(user!=null){
            return new DefaultResult(ResultCode.SUCCESS);
        }
        User user1=new User();
        user1.setUserTel(String.valueOf(b));
        user1.setPassword(PwdUtils.getPwd(b +String.valueOf(0)));
        user1.setOpenid(openId);
        int i = userMapper.insertSelective(user1);
        if(i>0){
            sm.setUserTel(String.valueOf(b));
            int i1 = smMapper.insertSelective(sm);
            if(i1>0){
                return new DefaultResult(ResultCode.SUCCESS);
            }
        }
        return new DefaultResult(ResultCode.SUCCESS);
    }
}
