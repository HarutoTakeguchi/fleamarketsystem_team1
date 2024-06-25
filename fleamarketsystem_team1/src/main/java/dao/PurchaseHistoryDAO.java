package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import bean.PurchaseHistory;

public class PurchaseHistoryDAO {
	
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
	public ArrayList<PurchaseHistory> selectByPurchase() {
		
		Connection con = null;
		Statement smt = null;
		
		PurchaseHistory purchaseHistory = new PurchaseHistory();
		
		//戻り値の設定
		ArrayList<PurchaseHistory> list = new ArrayList<PurchaseHistory>();
		
		try {
			
			//getConnection()メソッドを利用してConnectionオブジェクトを生成
			con = getConnection();
			
			//createStatement()メソッドを利用してStatementoオブジェクトを生成
			smt = con.createStatement();
			
			//SQL文を文字列として定義
			String sql = "SELECT p.name, p.price, p.quantity, o.shipment, o.deposit "
							+ "FROM product_info p INNER JOIN order_info o ON p.product_id=o.product_id";
			
			//SQL文を発行し結果セットを取得する
			ResultSet rs = smt.executeQuery(sql);
			
			//結果セットからデータを取り出して、PurchaseHistoryオブジェクトに格納する
			while(rs.next()) {
				purchaseHistory.setName(rs.getString("name"));
				purchaseHistory.setPrice(rs.getInt("price"));
				purchaseHistory.setQuantity(rs.getInt("quantity"));
				purchaseHistory.setShipment_status(rs.getString("shipment"));
				purchaseHistory.setDeposit_status(rs.getString("deposit"));
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
		return list;
	}

}
