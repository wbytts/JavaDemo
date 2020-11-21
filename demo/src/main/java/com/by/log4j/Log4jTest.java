package com.by.log4j;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.junit.Test;

public class Log4jTest {

    @Test
    public void test01() {
        // 初始化配置信息，在这里先不使用配置文件
        BasicConfigurator.configure();
        // 获取日志记录器对象
        Logger logger = Logger.getLogger(Log4jTest.class);
        // 日志记录输出
        logger.info("Hello log4j");

        // log4j 一共提供了 6 个日志级别
        logger.fatal("fatal");  // 严重错误，一般会造成系统崩溃并终止运行
        logger.error("error");  // 错误信息，一般不会影响系统运行
        logger.warn("warn");    // 警告信息，可能会发生问题
        logger.info("info");    // 运行信息，。。。
        logger.debug("debug");  // 调试信息，一般在开发阶段使用
        logger.trace("trace");  // 追踪信息，记录程序的所有日志
    }

}
