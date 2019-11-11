
package com.rimi.esports.controller;

import com.rimi.esports.common.ResultData;
import com.rimi.esports.service.IHotService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Wang Xiaoping
 * @date 2019/11/11 11:45
 */
@RestController
@CrossOrigin
public class HotController {
    private IHotService hotService;

    public HotController(IHotService hotService) {
        this.hotService = hotService;
    }
    @GetMapping("/hot/selectAll")
    @ApiOperation(value = "查询所有热门")
    public ResultData selectAll(){
       return hotService.selectAll();
    }
}
