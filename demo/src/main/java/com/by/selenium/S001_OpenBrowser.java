package com.by.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class S001_OpenBrowser {
    public static void main(String[] args) {

        openChrome();
    }

    public static void openFirefox() {
        /**
         * 打开firefox
         */
        FirefoxOptions options = new FirefoxOptions();
        options.setBinary("D:\\softwareInstallMenu\\Firefox\\firefox.exe");
        System.setProperty("webdriver.gecko.driver", ".\\drivers\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver(options);
        driver.get("http://www.baidu.com");
    }

    /**
     * 打开chrome
     */
    public static void openChrome() {
        // System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.baidu.com");

    }

    /**
     * 打开IE
     */
    public static void openIE() {
        System.setProperty("webdriver.ie.driver", ".\\drivers\\IEDriverServer.exe");
        WebDriver driver = new InternetExplorerDriver();
        driver.get("http://www.baidu.com");
    }

    /**
     * 打开Edge
     */
    public static void openEdge() {
        // 指定MicrosoftWebDriver路径
        System.setProperty("webdriver.edge.driver", ".\\drivers\\MicrosoftWebDriver.exe");
        //启动 Edge浏览器
        WebDriver driver = new EdgeDriver();
        driver.get("http://www.baidu.com");
    }
}