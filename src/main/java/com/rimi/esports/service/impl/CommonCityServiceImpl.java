package com.rimi.esports.service.impl;

import com.rimi.esports.beans.Commoncity;
import com.rimi.esports.common.DefaultResultData;
import com.rimi.esports.common.ResultData;
import com.rimi.esports.mapper.CommoncityMapper;
import com.rimi.esports.service.ICommonCityService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Wang Xiaoping
 * @date 2019/11/11 14:08
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class CommonCityServiceImpl implements ICommonCityService {
    private CommoncityMapper commoncityMapper;

    public CommonCityServiceImpl(CommoncityMapper commoncityMapper) {
        this.commoncityMapper = commoncityMapper;
    }

    @Override
    public ResultData selectByLocation(String commoncityLocation) {
        List<Commoncity> commoncities = commoncityMapper.selectByLocation(commoncityLocation);
        if(commoncities!=null&&commoncities.size()>0){
            return new DefaultResultData(commoncities);
        }
        return null;
    }
}
