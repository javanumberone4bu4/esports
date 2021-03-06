package com.rimi.esports.mapper;

import com.rimi.esports.beans.Mark;

/**
 * ${Description}
 *
 * @author Wang Xiaoping
 * @date 2019/11/6 14:29
 */
public interface MarkMapper {
    int deleteByPrimaryKey(Integer markId);

    int insert(Mark record);

    int insertSelective(Mark record);

    Mark selectByPrimaryKey(Integer markId);

    int updateByPrimaryKeySelective(Mark record);

    int updateByPrimaryKey(Mark record);

    Mark selectByUserTel(String userTel);
}