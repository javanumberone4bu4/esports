package com.rimi.esports.controller;

import com.rimi.esports.util.DownloadUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * 下载app
 *
 * @author Wang Xiaoping
 * @date 2019/11/4 9:22
 */
@RestController
@CrossOrigin
@Api(tags = {"下载app"})
public class DownloadController {
    @PostMapping("/download")
    @ApiOperation(value = "下载app,扫描二维码")
    public void download(HttpServletResponse response, HttpServletRequest request, Model model){
        DownloadUtils.download("/download","享动app下载",response,request);
    }
}
