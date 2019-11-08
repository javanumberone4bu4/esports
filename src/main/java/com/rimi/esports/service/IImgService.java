package com.rimi.esports.service;

import com.rimi.esports.beans.Img;
import com.rimi.esports.common.Result;
import com.rimi.esports.common.ResultData;

/**
 * 图片服务
 *
 * @author Wang Xiaoping
 * @date 2019/11/8 14:23
 */
public interface IImgService {
    /**
     * 查询所有图片
     * @return 结果数据
     */
    ResultData selectAll();

    Result insert(Img img);

    ResultData selectByImgPage(String imgPage);
}
