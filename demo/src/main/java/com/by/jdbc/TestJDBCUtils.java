package com.by.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestJDBCUtils {
    public static void main(String[] args) throws SQLException {
        Connection connection = JDBCUtils.getConnection();

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from article ");

        while(resultSet!=null && resultSet.next()) {
            System.out.println(resultSet.getString("title"));
        }

        JDBCUtils.release(connection, statement);
    }
}
