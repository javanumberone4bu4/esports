package com.rimi.esports.service.impl;

import com.rimi.esports.beans.Img;
import com.rimi.esports.common.*;
import com.rimi.esports.mapper.ImgMapper;
import com.rimi.esports.service.IImgService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Wang Xiaoping
 * @date 2019/11/8 14:24
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class ImgServiceImpl implements IImgService {
    private ImgMapper imgMapper;

    public ImgServiceImpl(ImgMapper imgMapper) {
        this.imgMapper = imgMapper;
    }

    @Override
    public ResultData selectAll() {
        List<Img> imgs = imgMapper.selectAll();
        if(imgs!=null&&imgs.size()>0){
            return new DefaultResultData(imgs);
        }
        return null;
    }

    @Override
    public Result insert(Img img) {
        if(img==null){
            return new DefaultResult(ResultCode.FAIL);
        }
        int i = imgMapper.insertSelective(img);
        if(i>0){
            return new DefaultResult(ResultCode.SUCCESS);
        }
        return new DefaultResult(ResultCode.FAIL);
    }

    @Override
    public ResultData selectByImgPage(String imgPage) {
        if(imgPage==null){
            return null;
        }
        List<Img> imgs = imgMapper.selectByImgPage(imgPage);
        if(imgs!=null && imgs.size()>0){
            return new DefaultResultData(imgs);
        }
        return null;
    }
}
