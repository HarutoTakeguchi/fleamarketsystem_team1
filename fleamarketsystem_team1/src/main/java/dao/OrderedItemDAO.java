package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import bean.OrderedItem;

public class OrderedItemDAO {
	// データベース接続情報
	private static String RDB_DRIVE = "org.mariadb.jdbc.Driver";
	private static String URL = "jdbc:mariadb://localhost/mybookdb";
	private static String USER = "root";
	private static String PASS = "root123";

	// データベースに接続するインスタンスメソッドを定義
	private static Connection getConnection() {

		Connection con = null;

		try {
			// Class.forNameメソッドを利用してJDBCドライバをロード
			Class.forName(RDB_DRIVE);

			// DriverManager.getConnectionメソッドを利用してConnectionオブジェクトを生成
			con = DriverManager.getConnection(URL, USER, PASS);

			// 生成されたConnectionオブジェクトをリターン
			return con;

		} catch (Exception e) {
			throw new IllegalStateException(e);
		}
	}

	// DBのorderinfoとbookinfoテーブルを結合して購入情報を取得するメソッド定義
	public ArrayList<OrderedItem> selectAll() {

		// 変数宣言
		Connection con = null;
		Statement smt = null;

		// return用オブジェクトの生成
		ArrayList<OrderedItem> orderedItemList = new ArrayList<OrderedItem>();

		// SQL文を文字列として定義
		String sql = "SELECT o.user,b.title,o.date FROM bookinfo b INNER JOIN orderinfo o ON b.isbn=o.isbn";

		try {
			// getConnection()メソッドを利用して、Connectionオブジェクトを生成
			con = getConnection();
			// ConnectionオブジェクトのcreateStatementメソッドを利用してStatementオブジェクトを生成
			smt = con.createStatement();

			// SQLをDBへ発行
			ResultSet rs = smt.executeQuery(sql);

			// 結果セットから書籍データを検索件数分全て取り出し、AllayListオブジェクトにBookオブジェクトとして格納
			while (rs.next()) {
				OrderedItem orderedItem = new OrderedItem();
				orderedItem.setUserid(rs.getString("o.user"));
				orderedItem.setName(rs.getString("b.title"));
				orderedItem.setSold_date(rs.getString("o.date"));
				orderedItemList.add(orderedItem);
			}

		} catch (Exception e) {
			throw new IllegalStateException(e);
		} finally {
			if (smt != null) {
				try {
					smt.close();
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
		return orderedItemList;

	}

}
