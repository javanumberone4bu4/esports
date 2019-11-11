package com.rimi.esports.service;

import com.rimi.esports.beans.Sm;
import com.rimi.esports.common.Result;
import com.rimi.esports.common.ResultData;

/**
 * @author Wang Xiaoping
 * @date 2019/10/30 20:18
 */
public interface ISmService {
    Result updateByTelephone(Sm sm);
    ResultData selectByTelephone(String userTel);
    Result save(Sm sm);
    ResultData selectBySmName(String smName);
    Result updateByUserTel(String smImage,String userTel);
}
