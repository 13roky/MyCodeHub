package com.broky.lesson04;

import com.broky.lesson02.utils.JdbcUtils;

import java.sql.*;

public class Transaction01 {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            conn = JdbcUtils.getConnection();
            conn.setAutoCommit(false);

            float trans = 500;


            String sql = "update user_money set money=money+? where name=?";
            st = conn.prepareStatement(sql);
            st.setFloat(1,trans);
            st.setObject(2,"s1mple");
            st.executeUpdate();

            sql = "update user_money set money=money+? where name=?";
            st = conn.prepareStatement(sql);
            st.setFloat(1,-trans);
            st.setObject(2,"zywoo");
            st.executeUpdate();

            conn.commit();
            System.out.println("commit success");

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            try {
                conn.rollback();
                System.out.println("rollback success");
            } catch (SQLException e) {
                System.out.println("rollback fail");
                e.printStackTrace();
            }

        } finally {
            JdbcUtils.release(conn,st,rs);
        }

    }
}
