package com.rimi.esports.controller;

import com.rimi.esports.beans.Mark;
import com.rimi.esports.common.DefaultResult;
import com.rimi.esports.common.Result;
import com.rimi.esports.common.ResultCode;
import com.rimi.esports.common.ResultData;
import com.rimi.esports.service.IMarkService;
import com.rimi.esports.vo.MarkVo;
import com.rimi.esports.vo.MarkVo1;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 积分交互层
 *
 * @author Wang Xiaoping
 * @date 2019/11/11 9:35
 */
@RestController
@CrossOrigin
public class MarkController {
    private IMarkService markService;

    public MarkController(IMarkService markService) {
        this.markService = markService;
    }
    @PostMapping("/mark/insert")
    @ApiOperation(value = "根据传入参数计算积分并插入")
    public Result insertMark(@RequestBody MarkVo vo){
        Mark mark1 = markService.selectMarkByUserTel(vo.getUserTel());
        if(mark1!=null){
            mark1.setMarkScore(mark1.getMarkScore()+Integer.parseInt(vo.getMarkSource())*20);
            mark1.setMarkSource(vo.getMarkSource());
            return markService.updateMark(mark1);
        }
        Mark mark=new Mark();
        mark.setUserTel(vo.getUserTel());
        int score = Integer.parseInt(vo.getMarkSource()) * 20;
        mark.setMarkSource(vo.getMarkSource());
        mark.setMarkScore(score);
        return markService.insertMark(mark);
    }
    @PostMapping("/mark/selectMark")
    @ApiOperation(value = "通过电话查询积分")
    public ResultData selectByUserTel(@RequestBody MarkVo1 vo1){
        return markService.selectByUserTel(vo1.getUserTel());
    }
}
