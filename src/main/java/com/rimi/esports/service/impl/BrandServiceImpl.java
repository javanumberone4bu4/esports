package com.rimi.esports.service.impl;

import com.rimi.esports.beans.Brand;
import com.rimi.esports.common.*;
import com.rimi.esports.mapper.BrandMapper;
import com.rimi.esports.service.IBrandService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Wang Xiaoping
 * @date 2019/10/30 20:21
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class BrandServiceImpl implements IBrandService {
    private BrandMapper brandMapper;

    public BrandServiceImpl(BrandMapper brandMapper) {
        this.brandMapper = brandMapper;
    }

    /**
     * 插入对象
     *
     * @param brand 品牌对象
     * @return 状态码
     */
    @Override
    public Result insertSelective(Brand brand) {
        if(brand==null){
            return new DefaultResult(ResultCode.FAIL);
        }
        int i = brandMapper.insertSelective(brand);
        if(i>0){
            return new DefaultResult(ResultCode.SUCCESS);
        }
        return new DefaultResult(ResultCode.FAIL);
    }

    /**
     * 通过品牌类型搜索
     *
     * @param brandType 品牌类型
     * @return 结果集合数据
     */
    @Override
    public ResultData selectByBrandType(String brandType) {
        if(brandType==null){
            return null;
        }
        List<Brand> brands = brandMapper.selectByBrandType(brandType);
        if(brands!=null&&brands.size()>0){
            return new DefaultResultData(brands);
        }
        return null;
    }

    /**
     * 通过品牌名字模糊查询
     *
     * @param brandName 品牌名字
     * @return 结果集合数据
     */
    @Override
    public ResultData selectLikeBrandName(String brandName) {
        if(brandName==null){
            return null;
        }
        List<Brand> brands = brandMapper.selectLikeBrandName(brandName);
        if(brands!=null&&brands.size()>0){
            return new DefaultResultData(brands);
        }
        return null;
    }

    /**
     * 查询品牌名字和品牌类型
     *
     * @return 结果集数据
     */
    @Override
    public ResultData selectByBrandNameAndBrandType() {
        List<Brand> brands = brandMapper.selectByBrandNameAndBrandBrandType();
        if(brands!=null&&brands.size()>0){
            return new DefaultResultData(brands);
        }
        return null;
    }

    @Override
    public ResultData selectByNameAndTypeAndLogoName() {
        List<Brand> brands = brandMapper.selectByNameAndTypeAndLogoName();
        if(brands!=null&&brands.size()>0){
            return new DefaultResultData(brands);
        }
        return null;
    }

    @Override
    public ResultData selectByParam() {
        List<Brand> brands = brandMapper.selectByParam();
        if(brands!=null&&brands.size()>0){
            return new DefaultResultData(brands);
        }
        return null;
    }

    @Override
    public ResultData selectByCondition(String brandType,String brandName) {
        List<Brand> brands = brandMapper.selectByCondition(brandType, brandName);
        if(brands!=null&&brands.size()>0){
            return new DefaultResultData(brands);
        }
        return null;
    }

    @Override
    public Brand selectToOrders(String brandType, String brandName) {
        Brand brand = brandMapper.selectToOrders(brandType, brandName);
        if(brand!=null){
            return brand;
        }
        return null;
    }
}
