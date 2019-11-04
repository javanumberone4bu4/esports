package com.rimi.esports.mapper;

import com.rimi.esports.beans.Brand;

/**
 * ${Description}
 * @author Wang Xiaoping
 * @date 2019/11/4 15:22
 */
public interface BrandMapper {
    int deleteByPrimaryKey(Integer brandId);

    int insert(Brand record);

    int insertSelective(Brand record);

    Brand selectByPrimaryKey(Integer brandId);

    int updateByPrimaryKeySelective(Brand record);

    int updateByPrimaryKey(Brand record);
}