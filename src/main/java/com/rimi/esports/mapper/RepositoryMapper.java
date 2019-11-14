package com.rimi.esports.mapper;

import com.rimi.esports.beans.Repository;

import java.util.List;

/**
 * ${Description}
 * @author Wang Xiaoping
 * @date 2019/11/13 11:58
 */
public interface RepositoryMapper {
    int deleteByPrimaryKey(Integer rId);

    int insert(Repository record);

    int insertSelective(Repository record);

    Repository selectByPrimaryKey(Integer rId);

    int updateByPrimaryKeySelective(Repository record);

    int updateByPrimaryKey(Repository record);

    List selectRepository();

}