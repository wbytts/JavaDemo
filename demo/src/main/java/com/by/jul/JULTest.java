package com.by.jul;

import java.io.IOException;
import java.io.InputStream;
import java.util.logging.*;

import org.junit.Test;

public class JULTest {


    /**
     * 快速入门
     */
    @Test
    public void testJUL01() {
        // 获取日志记录器对象
        Logger logger = Logger.getLogger("com.by.jul.JULTest");
        // 日志记录输出
        logger.info("Hello JUL");

        // 通用方法进行日志记录
        logger.log(Level.INFO, "INFO MESSAGE");

        // 通过占位符的方式输出变量的值
        String name = "wbytts";
        Integer age = 13;
        logger.log(Level.INFO, "name is {0}, age is {1}", new Object[]{name, age});
    }

    /**
     * 日志级别
     */
    @Test
    public void testLevel() throws IOException {
        // 获取日志记录器对象
        Logger logger = Logger.getLogger("com.by.jul.JULTest");

        // 关闭系统默认配置
        logger.setUseParentHandlers(false);
        // 自定义配置日志级别
        // 创建 consoleHandler  控制台
        ConsoleHandler consoleHandler = new ConsoleHandler();
        // 创建 simpleFormatter
        SimpleFormatter simpleFormatter = new SimpleFormatter();
        // 关联 consoleHandler 和 simpleFormatter
        consoleHandler.setFormatter(simpleFormatter);
        // 添加 consoleHandler 到 logger
        logger.addHandler(consoleHandler);

        // 配置日志的具体级别
        logger.setLevel(Level.ALL);
        consoleHandler.setLevel(Level.ALL);

        // 创建 FileHandler   文件
        FileHandler fileHandler = new FileHandler("f:/logs/jul.log");
        fileHandler.setFormatter(simpleFormatter);
        logger.addHandler(fileHandler);

        // 日志记录输出
        logger.severe("severe");
        logger.warning("warning");
        logger.info("info");      // JUL默认的日志级别是 INFO1
        logger.config("config");
        logger.fine("fine");
        logger.finer("finer");
        logger.finest("finest");
    }

    // Logger 对象的父子关系
    @Test
    public void testFuZi() {
        Logger logger1 = Logger.getLogger("com.by");
        Logger logger2 = Logger.getLogger("com");

        // 测试
        Logger logger1Parent = logger1.getParent();
        System.out.println(logger2 == logger1Parent);
        // LogManager$RootLogger 所有日志记录器的顶级父元素，name是空字符串
        System.out.println("logger2Parent:" + logger2.getParent() + ",name:" + logger2.getParent().getName());

        // 设计logger2的日志级别
        // 关闭系统默认配置
        logger2.setUseParentHandlers(false);
        // 自定义配置日志级别
        // 创建 consoleHandler  控制台
        ConsoleHandler consoleHandler = new ConsoleHandler();
        // 创建 simpleFormatter
        SimpleFormatter simpleFormatter = new SimpleFormatter();
        // 关联 consoleHandler 和 simpleFormatter
        consoleHandler.setFormatter(simpleFormatter);
        // 添加 consoleHandler 到 logger
        logger2.addHandler(consoleHandler);

        // 配置日志的具体级别
        logger2.setLevel(Level.ALL);
        consoleHandler.setLevel(Level.ALL);

        // 验证logger1的日志级别
        logger1.severe("severe");
        logger1.warning("warning");
        logger1.info("info");
        logger1.config("config");
        logger1.fine("fine");
        logger1.finer("finer");
        logger1.finest("finest");
    }

    // 加载自定义的配置文件
    @Test
    public void testAddSelfProperties() throws IOException {
        // 通过类加载器读取配置文件
        InputStream is = JULTest.class.getClassLoader().getResourceAsStream("logging.properties");
        // 创建 Logmanager
        LogManager logManager = LogManager.getLogManager();
        // 通过 logManager 加载配置文件
        logManager.readConfiguration(is);

        // 创建日志记录器
        Logger logger = Logger.getLogger("com.by");

        logger.severe("severe");
        logger.warning("warning");
        logger.info("info");
        logger.config("config");
        logger.fine("fine");
        logger.finer("finer");
        logger.finest("finest");
    }
}
