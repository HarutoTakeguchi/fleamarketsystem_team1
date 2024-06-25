/**
 * 作成：内山
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import bean.Sale;

public class SaleDAO {
	
	//DB情報をフィールド変数に定義
	private static String RDB_DRIVE = "org.mariadb.jdbc.Driver";
	private static String URL = "jdbc:mariadb://localhost/marketdb";
	private static String USER = "root";
	private static String PASSWD = "root123";
	
	//DB接続を行うメソッド定義
	public static Connection getConnection() {
		Connection con = null;
		try {
			Class.forName(RDB_DRIVE);
			con = DriverManager.getConnection(URL, USER, PASSWD);
			return con;
		} catch (Exception e) {
			throw new IllegalStateException(e);
		}
	}
	
	//DBのorderinfoとproductinfoテーブルを結合して売上情報を取得するメソッド定義
	public ArrayList<Sale> selectBySales() {
		
		Connection con = null;
		Statement smt = null;
		
		Sale sale = new Sale();
		
		//戻り値の設定
		ArrayList<Sale> SaleList = new ArrayList<Sale>();
		
		try {
			
			//getConnection()メソッドを利用してConnectionオブジェクトを生成
			con = getConnection();
			
			//createStatement()メソッドを利用してStatementoオブジェクトを生成
			smt = con.createStatement();
			
			//SQL文を文字列として定義
			String sql = "SELECT o.user_id, p.name, p.quantity,p.price, o.sold_date, p.price*0.1"
							+ "FROM order_info o INNER JOIN  product_info p ON o.user_id=p.user_id";
			
			//SQL文を発行し結果セットを取得する
			ResultSet rs = smt.executeQuery(sql);
			
			//結果セットからデータを取り出して、Saleオブジェクトに格納する
			while(rs.next()) {
				sale.setUser_id(rs.getInt("user_id"));
				sale.setName(rs.getString("name"));
				sale.setPrice(rs.getInt("price"));
				sale.setQuantity(rs.getInt("quantity"));
				sale.setSold_date(rs.getString("solddate"));
			} 
			
		} catch (Exception e) {
			throw new IllegalStateException(e);
		} finally {
			if ( smt != null ) {
				try { smt.close(); } catch (SQLException ignore) { }
			}
			if ( con != null ) {
				try { con.close(); } catch (SQLException ignore) { }
			}
		}
		return SaleList;
	}

}
