package com.broky.practice;

import org.w3c.dom.ls.LSOutput;

import java.sql.*;

public class Transaction {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            conn = JdbcUtilsPractice.getConnection();

            conn.setAutoCommit(false);


            String sql = "update users set name = 'suc' where id =?";
            st = conn.prepareStatement(sql);
            st.setInt(1,2);
            st.executeUpdate();

            // 测试事务
            if(0==0){
                throw new SQLException();
            }

            sql = "update users set password='suc' where id=?";
            st = conn.prepareStatement(sql);
            st.setInt(1,2);
            st.executeUpdate();

            conn.commit();
            System.out.println("commit success");

        } catch (SQLException throwables) {
            try {
                conn.rollback();
                System.out.println("rollback success");
            } catch (SQLException e) {
                e.printStackTrace();
            }
            throwables.printStackTrace();
        }finally {
            JdbcUtilsPractice.release(conn,st,rs);
        }

    }
}
