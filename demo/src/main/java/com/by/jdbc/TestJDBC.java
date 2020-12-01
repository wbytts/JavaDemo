package com.by.jdbc;

import org.junit.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author wangby
 */
public class TestJDBC {

    /**
     * 执行查询语句，打印结果
     * @throws SQLException
     */
    @Test
    public void test01() throws SQLException {
        Connection connection = JDBCUtil.getConnection();

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from user ");

        while(resultSet != null && resultSet.next()) {
            System.out.println(resultSet.getString("name"));
        }

        JDBCUtil.release(connection, statement);
    }

    @Test
    public void test02() throws SQLException {
        Connection connection = JDBCUtil.getConnection();

        Statement statement = connection.createStatement();

        JDBCUtil.release(connection, statement);
    }
}
