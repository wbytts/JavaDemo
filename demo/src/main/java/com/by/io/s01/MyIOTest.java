package com.by.io.s01;

import org.junit.Test;

import java.io.*;
import java.util.Arrays;

/**
 * @author wangby
 * @version 0.0.1
 * @date 2020-10-12 9:44
 */
public class MyIOTest {

    /**
     * 基本的输入输出流方法测试
     */
    @Test public void test01() throws IOException {
        InputStream is = new FileInputStream("f:/temp/temp.txt");
        int read = is.read();
        /*
            read() 方法：读取一个字节的数据
            read(buf) 方法：读取buf数据，写入到buf中，返回成功读取到的字节数
         */
        System.out.println(read);

        byte[] buf = new byte[16];
        is.read(buf);
        System.out.println(Arrays.toString(buf));

        // available()：可以读取的字节数的估计
        int available = is.available();
        System.out.println(available);

        is.close();
    }

    @Test public void test02() throws IOException {
        InputStream is = new FileInputStream("f:/temp/temp.txt");

        // 定义字节数组存放读取到的内容
        byte[] buf = new byte[16];
        StringBuilder sb = new StringBuilder();

        while(is.read(buf) != -1) {
            sb.append(new String(buf, "gbk"));
        }

        System.out.println(sb.toString());

        is.close();
    }

}
