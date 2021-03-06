package com.by.jdbc;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

/**
 * @author bingyi
 */
public class JDBCUtil {

    static String driverClass = null;
    static String url = null;
    static String name = null;
    static String password = null;

    static {
        try {
            // 建立一个属性配置对象
            Properties properties = new Properties();

            //使用类加载器，去获取src底下的文件，要自己创建jdbc.properties配置文件
            InputStream is = JDBCUtil.class.getClassLoader().getResourceAsStream("jdbc.properties");
            // System.out.println(JDBCUtils.class.getClassLoader().getResource("/").getPath());
            // Thread.currentThread().getContextClassLoader().getResourceAsStream("jdbc.properties");

            // 导入输入流
            properties.load(is);
            // 读取属性
            driverClass = properties.getProperty("driverClass");
            url = properties.getProperty("url");
            name = properties.getProperty("username");
            password = properties.getProperty("password");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        Connection conn = null;
        try {
            // 加载驱动类
            Class.forName(driverClass);
            conn = DriverManager.getConnection(url, name, password);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return conn;
    }

    /**
     *  释放资源
     * @param conn 连接
     * @param st Statement
     * @param rs ResultSet

     */
    public static void release(Connection conn, Statement st, ResultSet rs) {
        closeRs(rs);
        closeSt(st);
        closeConn(conn);
    }

    public static void release(Connection  conn, Statement st) {
        closeSt(st);
        closeConn(conn);
    }

    public static void release(Connection  conn) {
        closeConn(conn);
    }

    private static void closeRs(ResultSet rs) {
        try {
            if(rs != null) {
                rs.close();
            }
            rs = null;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            rs = null;
        }
    }

    private static void closeSt(Statement st) {
        try {
            if(st != null) {
                st.close();
            }
            st = null;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            st = null;
        }
    }

    private static void closeConn(Connection conn) {
        try {
            if(conn != null) {
                conn.close();
            }
            conn = null;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conn = null;
        }
    }

    
}