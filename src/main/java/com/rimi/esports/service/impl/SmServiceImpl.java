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
        int i = smMapper.updateByTelephone(sm);
        if(i>0){
            return new DefaultResult(ResultCode.SUCCESS);
        }
        return new DefaultResult(ResultCode.FAIL);
    }

    @Override
    public ResultData selectByTelephone(Sm sm) {
        Sm sm1 = smMapper.selectByTelephone(sm.getTelephone());
        if(sm1!=null){
            list=new ArrayList();
            list.add(sm);
            return new DefaultResultData(list);
        }
        list=new ArrayList();
        list.add(sm);
        return new DefaultResultData(list);
    }

    @Override
    public Result save(Sm sm) {
        int i = smMapper.insertSelective(sm);
        if(i>0){
            return new DefaultResult(ResultCode.SUCCESS);
        }
        return new DefaultResult(ResultCode.FAIL);
    }
}
