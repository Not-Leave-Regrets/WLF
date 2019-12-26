package com.wlf.page_helper.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wlf.page_helper.entity.Test;
import com.wlf.page_helper.mapper.TestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TestService {

    @Autowired
    private TestMapper testMapper;


    public PageInfo<Test> selAllList(Integer pageNum,Integer pageSize){
        Test test = new Test();
        test.setId(9);
        test.setUserName("add");
        test.setPassword("list");
        PageHelper.startPage(pageNum ==null ? 1:pageNum,pageSize==null ? 10:pageSize);
        List<Test> list = testMapper.selectAll();
        //额外往list中插入数据会导致分页数量增加，例如pageSize为3，add之后list的size为4
        list.add(test);
        PageInfo<Test> page = new PageInfo<>(list);
        return page;

    }
}
