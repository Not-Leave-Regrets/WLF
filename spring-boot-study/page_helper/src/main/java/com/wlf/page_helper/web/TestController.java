package com.wlf.page_helper.web;

import com.github.pagehelper.PageInfo;
import com.wlf.page_helper.entity.Test;
import com.wlf.page_helper.service.TestService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api("测试分页组件的使用")
public class TestController {

    @Autowired
    private TestService testService;
    @ApiOperation("测试分页组件")
    @GetMapping("/page")
    public PageInfo<Test> test(Integer pageNum,Integer pageSize){
        PageInfo<Test> page = testService.selAllList(pageNum, pageSize);
        return page;
    }
}
