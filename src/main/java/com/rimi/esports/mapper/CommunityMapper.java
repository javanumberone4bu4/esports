package com.rimi.esports.mapper;

import com.rimi.esports.beans.Community;

/**
 * ${Description}
 * @author Wang Xiaoping
 * @date 2019/11/6 21:53
 */
public interface CommunityMapper {
    int deleteByPrimaryKey(Integer communityId);

    int insert(Community record);

    int insertSelective(Community record);

    Community selectByPrimaryKey(Integer communityId);

    int updateByPrimaryKeySelective(Community record);

    int updateByPrimaryKey(Community record);
}