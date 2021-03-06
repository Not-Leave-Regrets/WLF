package com.wlf.capturedata.util;

import com.wlf.capturedata.JdParse;
import com.wlf.capturedata.Model;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.util.EntityUtils;

import java.util.ArrayList;
import java.util.List;

public class URLFecter {
    public static List<Model> URLParser (HttpClient client, String url) throws Exception {
        //用来接收解析的数据
        List<Model> JingdongData = new ArrayList<Model>();
        //获取网站响应的html，这里调用了HTTPUtils类
        HttpResponse response = HTTPUtils.getRawHtml(client, url);
        //获取响应状态码
        int StatusCode = response.getStatusLine().getStatusCode();
        //如果状态响应码为200，则获取html实体内容或者json文件
        if(StatusCode == 200){
            response.getEntity().getContent();
            String entity = EntityUtils.toString (response.getEntity(),"utf-8");    
            JingdongData = JdParse.getData(entity);
            EntityUtils.consume(response.getEntity());
        }else {
            //否则，消耗掉实体
            EntityUtils.consume(response.getEntity());
        }
        return JingdongData;
    }
}