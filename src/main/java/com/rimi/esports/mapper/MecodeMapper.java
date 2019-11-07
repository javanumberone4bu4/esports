package com.rimi.esports.mapper;

import com.rimi.esports.beans.Mecode;
import org.apache.ibatis.annotations.Param;

/**
 * ${Description}
 * @author Wang Xiaoping
 * @date 2019/11/7 22:46
 */
public interface MecodeMapper {
    int deleteByPrimaryKey(Integer mecodeId);

    int insert(Mecode record);

    int insertSelective(Mecode record);

    Mecode selectByPrimaryKey(Integer mecodeId);

    int updateByPrimaryKeySelective(Mecode record);

    int updateByPrimaryKey(Mecode record);

    Mecode selectByUserTel(String userTel);

    int updateByUserTel(@Param("number") String number, @Param("userTel") String userTel);
}