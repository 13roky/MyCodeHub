package com.broky.lesson01;

import java.sql.*;

// 我的第一个JDBC程序
public class JdbcFirstDemo {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // 1. 加载驱动
        Class.forName("com.mysql.cj.jdbc.Driver");     // 固定写法

        // 2. 用户信息和url
        String url = "jdbc:mysql://localhost:3306/jdbcstudy?useUnicode=true&characterEncoding=utf8&useSSL=true";
        String username = "root";
        String password = "20010223";
        // ?useUnicode=true&characterEncoding=utf8&useSSL=true
        // 写到?前就已经可以连接到数据库了, ?后面是可选参数
        // useUnicode=true              支持中文编码
        // characterEncoding=utf8       设置字符集为utf-8
        // useSSL=true                  使用ssl安全的连接

        // 3. 连接成功, 数据库对象
        Connection connection = DriverManager.getConnection(url, username, password);

        // 4. 执行sql的对象 Statement 执行sql的对象
        Statement statement = connection.createStatement();

        // 5. 执行sql的对象 去 执行sql, 可能存在结果, 查看返回结果
        String sql = "select * from users where name = 'lisi'";

        ResultSet resultSet = statement.executeQuery(sql); // 返回的结果集,结果集中封装了我们全部的查询出来的结果

        while (resultSet.next()) {
            System.out.println("id=" + resultSet.getInt("id"));
            System.out.println("name=" + resultSet.getString("name"));
            System.out.println("pwd=" + resultSet.getObject("password"));
            System.out.println("email=" + resultSet.getObject("email"));
            System.out.println("birth=" + resultSet.getObject("birthday"));
        }

        // 6. 释放连接
        resultSet.close();
        statement.close();
        connection.close();
    }
}
