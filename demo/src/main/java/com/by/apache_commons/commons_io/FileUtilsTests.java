package com.by.apache_commons.commons_io;

import org.apache.commons.io.FileUtils;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

public class FileUtilsTests {

    /**
     *  touch(File file)
     *  创建一个文件
     */
    @Test
    public void test01() throws IOException {
       FileUtils.touch(new File("F:/temp/test.txt"));
    }

}
