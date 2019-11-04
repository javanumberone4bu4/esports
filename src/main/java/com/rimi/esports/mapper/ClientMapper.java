package com.rimi.esports.mapper;

import com.rimi.esports.beans.Client;

/**
 * ${Description}
 * @author Wang Xiaoping
 * @date 2019/11/4 15:22
 */
public interface ClientMapper {
    int deleteByPrimaryKey(Integer clientId);

    int insert(Client record);

    int insertSelective(Client record);

    Client selectByPrimaryKey(Integer clientId);

    int updateByPrimaryKeySelective(Client record);

    int updateByPrimaryKey(Client record);
}