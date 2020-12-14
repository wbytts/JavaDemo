package com.by.http_client.s003_post;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author bingyi
 */
public class PostParamTest {
    public static void main(String[] args) throws UnsupportedEncodingException {
        // 打开浏览器
        CloseableHttpClient client = HttpClients.createDefault();
        // 输入网址，创建 HttpPost 对象
        HttpPost httpPost = new HttpPost("http://www.baidu.com");

        // 声明 List 集合，封装表单中的参数
        List<NameValuePair> params = new ArrayList<>();
        params.add(new BasicNameValuePair("key", "value"));
        params.add(new BasicNameValuePair("key2", "value2"));
        // 创建表单的Entity对象，第一个参数是封装好的表单列表，第二个是编码
        UrlEncodedFormEntity formEntity = new UrlEncodedFormEntity(params, "utf8");
        // 设置表单的Entity对象到Post请求中
        httpPost.setEntity(formEntity);
        // 发起请求，使用 HttpClient 对象发起请求
        CloseableHttpResponse response = null;
        try {
            response = client.execute(httpPost);
            // 解析响应，获取数据
            // 判断响应状态是否正常
            if(null != response && response.getStatusLine().getStatusCode()==200) {
                HttpEntity httpEntity = response.getEntity();
                String content = EntityUtils.toString(httpEntity, "utf8");
                System.out.println(content.length());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 资源的释放，关闭response
            try {
                if(null != response) {
                    response.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(null != client) {
                    client.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
