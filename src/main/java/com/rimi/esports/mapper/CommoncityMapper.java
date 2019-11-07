package com.rimi.esports.mapper;

import com.rimi.esports.beans.Commoncity;

/**
 * ${Description}
 * @author Wang Xiaoping
 * @date 2019/11/6 21:54
 */
public interface CommoncityMapper {
    int deleteByPrimaryKey(Integer commoncityId);

    int insert(Commoncity record);

    int insertSelective(Commoncity record);

    Commoncity selectByPrimaryKey(Integer commoncityId);

    int updateByPrimaryKeySelective(Commoncity record);

    int updateByPrimaryKey(Commoncity record);
}