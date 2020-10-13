package com.by.pdf;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Demo {
    public static void main(String[] args) throws Exception {
        FileInputStream fis = new FileInputStream("F:/eBook/test/lmx2572_wrapper.pdf");
        FileOutputStream fos = new FileOutputStream("F:/eBook/test/res1.pdf");

        byte[] temp = new byte[100000];
        int size = 0;
        while((size = fis.read(temp)) != -1){

            String s = new String(temp, "utf8");
            System.out.println(s);

            fos.write(temp, 0, size);
        }
        fis.close();
        fos.close();


    }
}
