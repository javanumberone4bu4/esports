package com.rimi.esports.service;


import com.rimi.esports.beans.Brand;
import com.rimi.esports.common.Result;
import com.rimi.esports.common.ResultData;

/**
 * @author Wang Xiaoping
 * @date 2019/10/30 20:21
 */

public interface IBrandService {
    /**
     * 插入对象
     * @param brand 品牌对象
     * @return 状态码
     */
    Result insertSelective(Brand brand);

    /**
     * 通过品牌类型搜索
     * @param brandType 品牌类型
     * @return 结果集合数据
     */
    ResultData selectByBrandType(String brandType);

    /**
     * 通过品牌名字模糊查询
     * @param brandName 品牌名字
     * @return 结果集合数据
     */
    ResultData selectLikeBrandName(String brandName);

    /**
     * 查询品牌名字和品牌类型
     * @return 结果集数据
     */
    ResultData selectByBrandNameAndBrandType();

    ResultData selectByNameAndTypeAndLogoName();

    ResultData selectByParam();

    ResultData selectByCondition(String brandType,String brandName);

    Brand selectToOrders(String brandType,String brandName);
}
