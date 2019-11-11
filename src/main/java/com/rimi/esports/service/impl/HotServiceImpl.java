package com.rimi.esports.service.impl;

import com.rimi.esports.beans.Hot;
import com.rimi.esports.common.DefaultResultData;
import com.rimi.esports.common.ResultData;
import com.rimi.esports.mapper.HotMapper;
import com.rimi.esports.service.IHotService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Wang Xiaoping
 * @date 2019/11/11 11:43
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class HotServiceImpl implements IHotService {
    private HotMapper hotMapper;

    public HotServiceImpl(HotMapper hotMapper) {
        this.hotMapper = hotMapper;
    }

    @Override
    public ResultData selectAll() {
        List<Hot> hots = hotMapper.selectAll();
        if(hots!=null&&hots.size()>0){
            return new DefaultResultData(hots);
        }
        return null;
    }
}
