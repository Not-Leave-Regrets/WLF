package com.wlf.capturedata.web;

import com.wlf.capturedata.util.URLFecter;
import io.swagger.annotations.ApiOperation;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class captureController {

    @ApiOperation("爬取数据")
    @GetMapping("/data")
    public void capture(String url){
        try {
            HttpClient client = new DefaultHttpClient();
            URLFecter.URLParser(client,url);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
