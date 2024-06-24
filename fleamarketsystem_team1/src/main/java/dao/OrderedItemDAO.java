// 作成者:後藤侑哉
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import bean.OrderedItem;

/**
 * このクラスではデータベースから購入状況と出品状況のデータ取得に関する処理がまとめられている
 *
 */
public class OrderedItemDAO {
	/**
	 * JDBCドライバ内部のDriverクラスパス
	 */
	private static final String RDB_DRIVE = "com.mysql.jdbc.Driver";
	/**
	 * 接続するMySQLデータベースパス
	 */
	private static final String URL = "jdbc:mysql://localhost/mybookdb";
	/**
	 * データベースのユーザー名
	 */
	private static final String USER = "root";
	/**
	 * データベースのパスワード
	 */
	private static final String PASSWD = "root123";

	/**
	 * フィールド変数の情報を基に、DB接続をおこなうメソッド
	 *
	 * @return データベース接続情報]
	 * @throws IllegalStateException
	 *             メソッド内部で例外が発生した場合
	 */
	private static Connection getConnection() {
		Connection con = null;
		try {
			Class.forName(RDB_DRIVE);
			con = DriverManager.getConnection(URL, USER, PASSWD);
			return con;
		} catch (Exception e) {
			throw new IllegalStateException(e);
		}
	}

	//DBorder_infoとproduct_infoから購入状況と出品状況のデータを全件取得するメソッド
	public ArrayList<OrderedItem> selectAll() {
		Connection con = null;
		Statement smt = null;
		ArrayList<OrderedItem> ordered_list = new ArrayList<OrderedItem>();

		try {
			con = getConnection();
			smt = con.createStatement();

			String sql = "SELECT p.user_id,p.name,p.price,o.deposit,o.shipment from product_info p inner join order_info o "
					+ "on p.product_id = o.product_id";
			ResultSet rs = smt.executeQuery(sql);

			while (rs.next()) {
				OrderedItem orderedItem = new OrderedItem();
				orderedItem.setUserid(rs.getString("user"));
				orderedItem.setDeposit_status(rs.getString("deposit"));
				orderedItem.setName(rs.getString("name"));
				orderedItem.setPrice(rs.getInt("price"));
				orderedItem.setShipment_status(rs.getString("shipment"));
				orderedItem.setQuantity(rs.getInt("quantity"));
				
				ordered_list.add(orderedItem);
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
		return ordered_list;
	}
}
