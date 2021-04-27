package com.broky.practice;

import com.broky.lesson02.utils.JdbcUtils;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class JdbcUtilsPractice {
    private static String driver = null;
    private static String url = null;
    private static String username = null;
    private static String password = null;


    static {
        try {
            InputStream in = JdbcUtils.class.getClassLoader().getResourceAsStream("db.properties");
            Properties properties = new Properties();
            properties.load(in);

            driver = properties.getProperty("driver");
            url = properties.getProperty("url");
            username = properties.getProperty("username");
            password = properties.getProperty("password");

            Class.forName(driver);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url,username,password);
    }

    // 查找方法
    public static void Query(String sql) {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            conn = DriverManager.getConnection(url, username, password);
            st = conn.createStatement();

            rs = st.executeQuery(sql);

            while (rs.next()) {
                System.out.println(rs.getString("name"));
                System.out.println(rs.getString("email"));
                System.out.println(rs.getInt("password"));
            }

        } catch (Exception throwables) {
            throwables.printStackTrace();
        } finally {
            JdbcUtilsPractice.release(conn, st, rs);
        }
    }

    public static void ExecUpdate(String sql) {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            conn = DriverManager.getConnection(url, username, password);
            st = conn.createStatement();

            int i = st.executeUpdate(sql);

            if (i > 0) {
                System.out.println("执行成功");
            }

        } catch (Exception throwables) {
            throwables.printStackTrace();
        } finally {
            JdbcUtilsPractice.release(conn, st, rs);
        }
    }

    public static void release(Connection conn, Statement st, ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        if (st != null) {
            try {
                st.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

}


