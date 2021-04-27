package com.broky.lesson02.utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestQuery {
    public static void main(String[] args) {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            conn = JdbcUtils.getConnection();   //获取数据库连接
            st = conn.createStatement();        //获得sql执行对象
            String sql = "select * from users where id=1";

            rs = st.executeQuery(sql);

            if (rs.next()) {
                System.out.println(rs.getString("name"));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JdbcUtils.release(conn, st, rs);
        }
    }
}
