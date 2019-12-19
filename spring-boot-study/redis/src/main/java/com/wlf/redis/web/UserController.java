package com.wlf.redis.web;

import com.wlf.redis.entity.User;
import com.wlf.redis.mapper.UserMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api
public class UserController {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RedisTemplate redisTemplate;

    @GetMapping("putRedis")
    @ApiOperation("测试将值放入到redis中")
    public String putRedis(){
        try {
            List<User> users = userMapper.selectAll();
            redisTemplate.opsForValue().set("users",users);
        } catch (Exception e) {
            e.printStackTrace();
            return "false";
        }
        return "success";
    }
    @GetMapping("getRedis")
    @ApiOperation("测试从redis中获取值")
    public Object getRedis(){
        Object users1=null;
        try {
            users1 = redisTemplate.opsForValue().get("users");
        } catch (Exception e) {
            e.printStackTrace();
            return "false";
        }
        return users1;
    }

}
