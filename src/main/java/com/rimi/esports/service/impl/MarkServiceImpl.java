package com.rimi.esports.service.impl;

import com.rimi.esports.beans.Mark;
import com.rimi.esports.common.*;
import com.rimi.esports.mapper.MarkMapper;
import com.rimi.esports.service.IMarkService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Wang Xiaoping
 * @date 2019/10/30 20:20
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class MarkServiceImpl implements IMarkService {
    private MarkMapper markMapper;
    private List list;
    public MarkServiceImpl(MarkMapper markMapper) {
        this.markMapper = markMapper;
    }

    /**
     * 插入积分数
     *
     * @param mark
     * @return 是否成功
     */
    @Override
    public Result insertMark(Mark mark) {
        //根据传入的积分来源计算分数
        if(mark==null){
            return new DefaultResult(ResultCode.FAIL);
        }
        int i = markMapper.insertSelective(mark);
        if(i>0){
            return new DefaultResult(ResultCode.SUCCESS);
        }
        return new DefaultResult(ResultCode.FAIL);
    }

    @Override
    public Mark selectMarkByUserTel(String userTel) {
        if(userTel==null){
            return null;
        }
        Mark mark = markMapper.selectByUserTel(userTel);
        if(mark!=null){
            return mark;
        }
        return null;
    }

    /**
     * 搜索积分数
     *
     * @param userTel 电话号码
     * @return 结果集数据
     */
    @Override
    public ResultData selectByUserTel(String userTel) {
        if(userTel==null){
            return null;
        }
        Mark mark = markMapper.selectByUserTel(userTel);
        if(mark!=null){
            list=new ArrayList();
            list.add(mark);
            return new DefaultResultData(list);
        }
        return null;
    }

    @Override
    public Result updateMark(Mark mark) {
        if(mark==null){
            return new DefaultResult(ResultCode.FAIL);
        }
        int i = markMapper.updateByPrimaryKeySelective(mark);
        if(i>0){
            return new DefaultResult(ResultCode.SUCCESS);
        }
        return new DefaultResult(ResultCode.FAIL);
    }
}
