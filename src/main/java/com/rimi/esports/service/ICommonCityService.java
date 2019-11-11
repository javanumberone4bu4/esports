package com.rimi.esports.service;

import com.rimi.esports.common.ResultData;

/**
 * @author Wang Xiaoping
 * @date 2019/11/11 14:07
 */
public interface ICommonCityService {
    ResultData selectByLocation(String commoncityLocation);
}
