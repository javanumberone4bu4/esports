package com.rimi.esports.controller;


import com.rimi.esports.common.*;
import com.rimi.esports.util.FastDfsUtils;
import com.rimi.esports.util.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * 文件上传
 *
 * @author chenjin
 * @date 2019/11/4 9:14
 */
@RestController
@CrossOrigin
public class FileUploadController {

    @PostMapping("/uploadFile")
    private Result uploadFile1(MultipartFile file, HttpServletRequest request){
        String fileName = null;
        //文件上传
        try {
            //fileName虚拟机的地址
            fileName = FastDfsUtils.upload(file.getBytes(), FileUtils.getFileSuffix(file.getOriginalFilename()));
            System.out.println(fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return  new DefaultResult(ResultCode.SUCCESS);
    }

}
