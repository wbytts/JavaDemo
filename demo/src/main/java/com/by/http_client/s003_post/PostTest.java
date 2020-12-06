package com.by.http_client.s003_post;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class PostTest {
    public static void main(String[] args) {
        // 打开浏览器
        CloseableHttpClient client = HttpClients.createDefault();
        // 输入网址，创建 HttpPost 对象
        HttpPost httpPost = new HttpPost("http://bomc.js.cmcc/swb/rest/ebomc/lastMonthBulletins");
        // 发起请求，使用 HttpClient 对象发起请求
        CloseableHttpResponse response = null;
        try {
            response = client.execute(httpPost);
            // 解析响应，获取数据
            // 判断响应状态是否正常
            if(response.getStatusLine().getStatusCode()==200) {
                HttpEntity httpEntity = response.getEntity();
                String content = EntityUtils.toString(httpEntity, "utf8");
                System.out.println(content.length());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 资源的释放，关闭response
            try {
                response.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                client.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
