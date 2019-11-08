package com.rimi.esports.mapper;

import com.rimi.esports.beans.Img;

import java.util.List;

/**
 * ${Description}
 * @author Wang Xiaoping
 * @date 2019/11/8 9:52
 */
public interface ImgMapper {
    int deleteByPrimaryKey(Integer imgId);

    int insert(Img record);

    int insertSelective(Img record);

    Img selectByPrimaryKey(Integer imgId);

    int updateByPrimaryKeySelective(Img record);

    int updateByPrimaryKey(Img record);

    List<Img> selectAll();

    List<Img> selectByImgPage(String imgPage);
}