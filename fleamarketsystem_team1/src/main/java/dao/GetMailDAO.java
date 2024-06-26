package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.MAil;

public class GetMailDAO {

    private static String RDB_DRIVE = "org.mariadb.jdbc.Driver";
    private static String URL = "jdbc:mariadb://localhost/marketdb";
    private static String USER = "root";
    private static String PASS = "root123";

    private static Connection getConnection() {
        try {
            Class.forName(RDB_DRIVE);
            Connection con = DriverManager.getConnection(URL, USER, PASS);
            return con;
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    public MAil getRegistarMail(String productid) {

        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        MAil mail = new MAil();

        try {
            con = getConnection();
            String sql = "SELECT user_info.email " +
                         "FROM product_info " +
                         "JOIN user_info ON product_info.user_id = user_info.user_id " +
                         "WHERE product_info.product_id = ?";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, productid);

            rs = pstmt.executeQuery();

            if (rs.next()) {
                mail.setMail(rs.getString("email"));
            }

        } catch (Exception e) {
            throw new IllegalStateException(e);
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ignore) {
                }
            }
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException ignore) {
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException ignore) {
                }
            }
        }
        return mail;
    }
    public MAil getMailByOrderNo(String orderNo) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        MAil mail = new MAil();

        try {
            con = getConnection();
            String sql = "SELECT user_info.email " +
                         "FROM order_info " +
                         "JOIN user_info ON order_info.user_id = user_info.user_id " +
                         "WHERE order_info.order_no = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1, orderNo);
            rs = ps.executeQuery();

            if (rs.next()) {
                mail.setMail(rs.getString("email"));
            }
        } catch (SQLException e) {
            throw new IllegalStateException("Database connection error", e);
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                // エラーハンドリング
            }
        }
        return mail;
    }
}
