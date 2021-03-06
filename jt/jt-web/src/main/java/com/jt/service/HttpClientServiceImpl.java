package com.jt.service;

import com.jt.util.ObjectMapperUtil;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class HttpClientServiceImpl implements HttpClientService{

    @Override
    public String findUserList() {
        HttpClient httpClient = HttpClients.createDefault();
        String url = "http://sso.jt.com/user/findUserList";
        HttpGet httpGet = new HttpGet(url);
        try {
            HttpResponse execute = httpClient.execute(httpGet);
            if(execute.getStatusLine().getStatusCode() == 200){
                String json = EntityUtils.toString(execute.getEntity(),"utf-8");
                return json;
            }else{
                throw new RuntimeException("服务器相应失败");
            }

        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }
}
