package com.rimi.esports.controller;

import com.rimi.esports.beans.Img;
import com.rimi.esports.common.Result;
import com.rimi.esports.common.ResultData;
import com.rimi.esports.mapper.ImgMapper;
import com.rimi.esports.service.IImgService;
import com.rimi.esports.vo.ImgVo;
import com.rimi.esports.vo.ImgVo1;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 图片处理服务
 *
 * @author Wang Xiaoping
 * @date 2019/11/8 17:32
 */
@RestController
@CrossOrigin
public class ImgController {
  private IImgService iImgService;

    public ImgController(IImgService iImgService) {
        this.iImgService = iImgService;
    }

    @PostMapping("/img/getPhoto")
    @ApiOperation(value = "查看所有图片")
    public ResultData showPhotos(){
       return iImgService.selectAll();
    }
    @PostMapping("/img/insertPhoto")
    @ApiOperation(value = "插入图片")
    public Result insertPhotos(@RequestBody ImgVo vo){
        Img img=new Img();
        img.setImgPage(vo.getImgPage());
        img.setImgPath(vo.getImgPath());
        return iImgService.insert(img);
    }
    @PostMapping("/img/showPhoto")
    @ApiOperation(value = "根据条件查看所有图片路径")
    public ResultData findPhotos(@RequestBody ImgVo1 vo1){
        return iImgService.selectByImgPage(vo1.getImgPage());
    }
}
