package com.rimi.esports.mapper;

import com.rimi.esports.beans.Hot;

/**
 * ${Description}
 * @author Wang Xiaoping
 * @date 2019/11/6 21:54
 */
public interface HotMapper {
    int deleteByPrimaryKey(Integer hotId);

    int insert(Hot record);

    int insertSelective(Hot record);

    Hot selectByPrimaryKey(Integer hotId);

    int updateByPrimaryKeySelective(Hot record);

    int updateByPrimaryKey(Hot record);
}