package com.by.base64;

import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

public class Base64Demo {

    @Test
    public void test01() throws UnsupportedEncodingException {
        String src = "你好啊";

        // 编码
        byte[] encode_bytes = Base64.getEncoder().encode(src.getBytes("UTF-8"));
        String dst = new String(encode_bytes, "UTF-8");
        System.out.println(dst);

        // 解码
        byte[] decode_bytes = Base64.getDecoder().decode(dst.getBytes("UTF-8"));
        System.out.println(new String(decode_bytes, "UTF-8"));
    }

}
