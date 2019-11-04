package com.rimi.esports.mapper;

import com.rimi.esports.beans.Sm;

/**
 * ${Description}
 * @author Wang Xiaoping
 * @date 2019/11/4 15:21
 */
public interface SmMapper {
    int deleteByPrimaryKey(Integer smId);

    int insert(Sm record);

    int insertSelective(Sm record);

    Sm selectByPrimaryKey(Integer smId);

    int updateByPrimaryKeySelective(Sm record);

    int updateByPrimaryKey(Sm record);
}