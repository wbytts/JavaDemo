package com.by.spider.http_client.s004_connection_pool;

import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;

/**
 * @author bingyi
 */
public class PoolTest {
    public static void main(String[] args) {
        // 创建连接池管理器
        PoolingHttpClientConnectionManager cm = new PoolingHttpClientConnectionManager();

        // 设置连接数
        cm.setMaxTotal(100);
        // 设置每个主机的最大连接数
        cm.setDefaultMaxPerRoute(10);


        // 使用连接池管理器发起请求
        doGet(cm);
        doGet(cm);
    }

    private static void doGet(PoolingHttpClientConnectionManager cm) {
        CloseableHttpClient client = HttpClients.custom().setConnectionManager(cm).build();

        // ......

        // 注意：这里不能关闭client，因为这个现在是由连接池进行管理的
    }
}
