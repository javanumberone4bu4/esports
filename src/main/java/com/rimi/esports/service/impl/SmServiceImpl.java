package com.rimi.esports.service.impl;

import com.rimi.esports.beans.Sm;
import com.rimi.esports.common.*;
import com.rimi.esports.mapper.SmMapper;
import com.rimi.esports.service.ISmService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Wang Xiaoping
 * @date 2019/10/30 20:18
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class SmServiceImpl implements ISmService {
    private SmMapper smMapper;
    private List list;
    public SmServiceImpl(SmMapper smMapper) {
        this.smMapper = smMapper;
    }

    @Override
    public Result updateByTelephone(Sm sm) {
        if(sm==null){
            return new DefaultResult(ResultCode.FAIL);
        }
        int i = smMapper.updateByTelephone(sm);
        if(i>0){
            return new DefaultResult(ResultCode.SUCCESS);
        }
        return new DefaultResult(ResultCode.FAIL);
    }

    @Override
    public ResultData selectByTelephone(String userTel) {
        if(userTel==null){
            return null;
        }
        Sm sm1 = smMapper.selectByTelephone(userTel);
        if(sm1!=null){
            list=new ArrayList();
            list.add(sm1);
            return new DefaultResultData(list);
        }

        return null;
    }

    @Override
    public Result save(Sm sm) {
        if(sm==null){
            return new DefaultResult(ResultCode.FAIL);
        }
        int i = smMapper.insertSelective(sm);
        if(i>0){
            return new DefaultResult(ResultCode.SUCCESS);
        }
        return new DefaultResult(ResultCode.FAIL);
    }

    @Override
    public ResultData selectBySmName(String smName) {
        if(smName==null){
            return null;
        }
        List list = smMapper.selectBySmName(smName);
        if(list!=null&&list.size()>0){
            return new DefaultResultData(list);
        }

        return null;
    }

    @Override
    public Result updateByUserTel(String smImage, String userTel) {
        if(smImage==null||userTel==null){
            return new DefaultResult(ResultCode.FAIL);
        }
        int i = smMapper.updateBySmImage(smImage, userTel);
        if(i>0){
            return new DefaultResult(ResultCode.SUCCESS);
        }
        return new DefaultResult(ResultCode.FAIL);
    }

    @Override
    public Sm selectBySmNameWeiXin(String smName) {
        Sm sm = smMapper.selectBySmNameWeiXin(smName);
        if(sm!=null){
            return sm;
        }
        return null;
    }

    @Override
    public ResultData selectWeiXinMessage(String smName) {
        Sm sm = smMapper.selectWeiXinMessage(smName);
        if(sm!=null){
            list=new ArrayList();
            list.add(sm);
            return new DefaultResultData(list);
        }
        return null;
    }
}
