//作成者：石井

package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import bean.Product;

public class OrderDAO {

	//データベース接続情報
	private static String RDB_DRIVE ="org.mariadb.jdbc.Driver";
	private static String URL ="jdbc:mariadb://localhost/marketdb";
	private static String USER ="root";
	private static String PASS ="root123";

	private static Connection getConnection(){
		try{
			Class.forName(RDB_DRIVE);
			Connection con = DriverManager.getConnection(URL,USER,PASS);
			return con ;
		}catch(Exception e){
			throw new IllegalStateException(e);
		}
	} 

	//引数の購入データを元にDBのorderinfoテーブルに新規登録処理を行うメソッド
	public void insert(Product product){

		Connection con = null;//DBコネクション
		Statement smt = null;//SQLステートメント

		try{
			//DB接続
			con = getConnection();
			smt = con.createStatement();

			//SQL文作成
			String sql = "INSERT INTO orderinfo VALUES(NULL, '" + product.getUserid() + "', '" + product.getProductid() + "', CURDATE(), 0, 0, 0)";
			//SQL文発行
			smt.executeUpdate(sql);

		}catch(Exception e){
			throw new IllegalStateException(e);
		}finally{
			if( smt != null ){
				try{smt.close();}catch(SQLException ignore){}
			}
			if( con != null ){
				try{con.close();}catch(SQLException ignore){}
			}
			
			
			
		}
	}
	public int getOrderNoByProductId(int productId) {
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        int orderNo = -1; // デフォルト値として-1を設定（存在しない場合などに備えて）

        try {
            con = getConnection();
            stmt = con.createStatement();

            String sql = "SELECT order_no FROM order_info WHERE product_id = " + productId;
            rs = stmt.executeQuery(sql);

            if (rs.next()) {
                orderNo = rs.getInt("order_no");
            }
        } catch (SQLException e) {
            throw new IllegalStateException("Database connection error", e);
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                // エラーハンドリング
            }
        }
        return orderNo;
    }
}