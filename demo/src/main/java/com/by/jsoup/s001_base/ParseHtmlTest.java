package com.by.jsoup.s001_base;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.Test;

import java.net.URL;

/**
 * @author bingyi
 */
public class ParseHtmlTest {
    public static void main(String[] args) {
        String html = "<html><head><title>First parse</title></head>"
                + "<body><p>Parsed HTML into a doc.</p></body></html>";
        Document doc = Jsoup.parse(html);
        System.out.println(doc);
    }

    @Test
    public void testJsoupURL() throws Exception {
        // 解析url地址，第一个参数是访问的url，第二个参数是访问的超时时间
        Document doc = Jsoup.parse(new URL("http://www.baidu.com"), 1000);

        // 使用标签选择器获取title的内容
        String title = doc.getElementsByTag("title").first().text();
        System.out.println(title);
    }

    @Test
    public void testParseString() throws Exception {
        // 解析字符串

    }
}
