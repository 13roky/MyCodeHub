package com.broky.lesson02.utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestInsert {
    public static void main(String[] args) {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            conn = JdbcUtils.getConnection();   //获取数据库连接
            st = conn.createStatement();        //获得sql执行对象
            String sql = "INSERT INTO users(id,`name`,`password`,email,birthday)\n" +
                    "VALUES(4,'13roky','20010223','215029692@qq.com','2020-01-01')";
            int i = st.executeUpdate(sql);

            if (i > 0) {
                System.out.println("插入成功!!!");
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JdbcUtils.release(conn, st, rs);
        }
    }
}
