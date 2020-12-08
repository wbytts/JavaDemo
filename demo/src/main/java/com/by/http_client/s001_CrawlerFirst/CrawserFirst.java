package com.by.http_client.s001_CrawlerFirst;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * @author bingyi
 */
public class CrawserFirst {
    public static void main(String[] args) throws IOException {
        // 打开浏览器 CloseableHttpClient 可关闭的 Http 客户端
        CloseableHttpClient client = HttpClients.createDefault();
        // 输入网址，创建 HttpGet 对象
        HttpGet httpGet = new HttpGet("http://www.baidu.com");
        // 发起请求，使用 HttpClient 对象发起请求
        CloseableHttpResponse response = client.execute(httpGet);
        // 解析响应，获取数据
        // 判断响应状态是否正常
        if (response.getStatusLine().getStatusCode() == 200) {
            HttpEntity httpEntity = response.getEntity();
            String content = EntityUtils.toString(httpEntity, "utf8");
            System.out.println(content);
        }
    }
}
