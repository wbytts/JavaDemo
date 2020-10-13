package com.by.thread.threadclass;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;

// 练习Thread，实现多线程同步下载图片
public class DownloadPicture extends Thread {
    private String url = "";
    private String name = "";

    public DownloadPicture(String url, String name) {
        this.url = url;
        this.name = name;
    }

    public static void main(String[] args) {
        DownloadPicture dp1 = new DownloadPicture("http://www.ruoyi.vip/images/ibanner_img_01.png", "d:/temp/images/1.png");
        DownloadPicture dp2 = new DownloadPicture("http://www.ruoyi.vip/images/ic_item_02.png", "d:/temp/images/2.png");
        DownloadPicture dp3 = new DownloadPicture("http://www.ruoyi.vip/images/ic_item_03.png", "d:/temp/images/3.png");

        dp1.start();
        dp2.start();
        dp3.start();
    }

    @Override
    public void run() {
        WebDownload webDownload = new WebDownload();
        webDownload.downloader(this.url, this.name);
        System.out.println("下载了文件 " + this.name);
    }
}

class WebDownload {
    public void downloader(String url, String filename) {
        try {
            FileUtils.copyURLToFile(new URL(url), new File(filename));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("IO异常，downloader方法出现问题");
        }

    }
}