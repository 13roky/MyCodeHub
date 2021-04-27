package com.broky.practice;

import java.sql.*;

public class PrepareSt {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            conn = JdbcUtilsPractice.getConnection();

            String sql = "select * from users where id=?";

            st = conn.prepareStatement(sql);

            st.setInt(1, 2);

            rs = st.executeQuery();

            while (rs.next()) {
                System.out.println(rs.getObject("id"));
                System.out.println(rs.getObject("name"));
            }


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JdbcUtilsPractice.release(conn, st, rs);
        }

    }
}
