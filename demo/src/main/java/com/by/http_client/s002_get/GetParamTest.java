package com.by.http_client.s002_get;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * @author bingyi
 */
public class GetParamTest {
    public static void main(String[] args) {
        // 打开浏览器
        CloseableHttpClient client = HttpClients.createDefault();

        HttpGet httpGet = null;
        // 设置请求参数
        // 创建 URIBuilder

        try {
            // 构建带参数的 URI
            URI uri = new URIBuilder("http://www.baidu.com")
                    .setParameter("key", "value")
                    .setParameter("key2", "value2")
                    .build();
            // 创建 HttpGet 对象
            httpGet = new HttpGet(uri);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        // 发起请求，使用 HttpClient 对象发起请求
        CloseableHttpResponse response = null;
        try {
            response = client.execute(httpGet);
            // 解析响应，获取数据
            // 判断响应状态是否正常
            if (response.getStatusLine().getStatusCode() == 200) {
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
