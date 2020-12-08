package com.by.http_client.s005_request_params;

import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * @author bingyi
 */
public class RequestParamsTest {
    public static void main(String[] args) {
        // 打开浏览器
        CloseableHttpClient client = HttpClients.createDefault();

        // String url = "http://www.baidu.com";
        String flag = "ls";
        String url = "http://10.33.248.39:20020/x_organization_assemble_control/jaxrs/person/" + flag;

        // 输入网址，创建 HttpGet 对象
        HttpGet httpGet = new HttpGet(url);

        // 配置请求信息
        RequestConfig config = RequestConfig.custom()
                .setConnectTimeout(1000) // 创建连接的最长时间，单位毫秒
                .setConnectionRequestTimeout(500) // 设置获取连接的最长时间，单位毫秒
                .setSocketTimeout(10 * 1000) // 设置数据传输的最长时间，单位毫秒
                .build();
        // 给请求设置请求信息
        httpGet.setConfig(config);
        httpGet.setHeader("x-token", "PfyuxmzgIzr1AXDgr1ukBHym59XORoHx50QnO7mEHhA");
        httpGet.setHeader("x-debuger", "true");

        // 发起请求，使用 HttpClient 对象发起请求
        CloseableHttpResponse response = null;
        try {
            response = client.execute(httpGet);
            // 解析响应，获取数据
            // 判断响应状态是否正常
            if (response.getStatusLine().getStatusCode() == 200) {
                HttpEntity httpEntity = response.getEntity();
                String content = EntityUtils.toString(httpEntity, "utf8");
                // System.out.println(content.length());
                System.out.println(content);
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
