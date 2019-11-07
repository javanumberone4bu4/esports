package com.rimi.esports.controller;

import com.rimi.esports.common.DefaultResult;
import com.rimi.esports.common.Result;
import com.rimi.esports.common.ResultCode;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 全局异常处理
 *
 * @author Wang Xiaoping
 * @date 2019/11/5 14:14
 */
@ControllerAdvice
public class ExceptionController {
    @ResponseBody
    @ExceptionHandler(Exception.class)
    public Result error(Exception e){
        e.printStackTrace();
        return new DefaultResult(ResultCode.ERROR);
    }
}
