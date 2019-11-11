package com.rimi.esports.service;

import com.rimi.esports.beans.Mark;
import com.rimi.esports.common.Result;
import com.rimi.esports.common.ResultData;

/**
 * @author Wang Xiaoping
 * @date 2019/10/30 20:19
 */
public interface IMarkService {
    /**
     * 插入积分数
     * @return 是否成功
     */
    Result insertMark(Mark mark);

    /**
     * 搜索积分数
     * @param userTel 电话号码
     * @return 结果集数据
     */
    ResultData selectByUserTel(String userTel);
}
