package com.rimi.esports.mapper;

import com.rimi.esports.beans.Brand;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * ${Description}
 * @author Wang Xiaoping
 * @date 2019/11/8 10:21
 */
public interface BrandMapper {
    int deleteByPrimaryKey(Integer brandId);

    int insert(Brand record);

    int insertSelective(Brand record);

    Brand selectByPrimaryKey(Integer brandId);

    int updateByPrimaryKeySelective(Brand record);

    int updateByPrimaryKey(Brand record);

    List<Brand> selectByBrandType(String brandType);

    List<Brand> selectLikeBrandName(String brandName);

    List<Brand> selectByBrandNameAndBrandBrandType();

    List<Brand> selectByNameAndTypeAndLogoName();

    List<Brand> selectByParam();

    List<Brand> selectByCondition(@Param("brandType") String brandType,@Param("brandName")String brandName);
}