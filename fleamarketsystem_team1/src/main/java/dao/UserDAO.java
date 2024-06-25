//作成者：竹口

package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import bean.User;

public class UserDAO {
	// データベース接続情報
	private static String RDB_DRIVE = "org.mariadb.jdbc.Driver";
	private static String URL = "jdbc:mariadb://localhost/marketdb";
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

	// DBのuserinfoテーブルから指定ユーザーとパスワードの条件に合致する情報を取得するメソッド定義
	public User selectByUser(String username, String password) {

		// 変数宣言
		Connection con = null;
		Statement smt = null;

		// return用オブジェクトの生成
		User user = new User();

		// SQL文の設定
		String sql = "SELECT * FROM user_info WHERE user_name = '" + username +
				"' AND password = '" + password + "'";

		try {

			// getConnectionメソッドを利用してConnectionオブジェクトを生成
			con = getConnection();
			// Connectionオブジェクトのメソッドを利用してStatementオブジェクトを生成
			smt = con.createStatement();
			// Statementオブジェクトのメソッドを利用して、SQL文を発行し結果セットを取得
			ResultSet rs = smt.executeQuery(sql);

			// 結果セットからユーザーデータを取り出し、Userオブジェクトに格納
			while (rs.next()) {
				user.setUserid(rs.getString("user_id"));
				user.setPassword(rs.getString("password"));
				user.setAuthority(rs.getString("authority"));
				user.setUsername(rs.getString("user_name"));
				user.setName(rs.getString("name"));
				user.setAddress(rs.getString("address"));
				user.setAge(rs.getInt("age"));
				user.setEmail(rs.getString("email"));
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
		return user;

	}

	// DBのuser_infoテーブルから全ユーザー情報を取得するメソッド定義
	public ArrayList<User> selectAll() {

		// 変数宣言
		Connection con = null;
		Statement smt = null;

		// return用オブジェクトの生成
		ArrayList<User> userList = new ArrayList<User>();

		// SQL文を文字列として定義。権限1（管理者）を除いたユーザーを検索するSQL文
		String sql = 
			"SELECT A.user_id, A.user_name, A.name, A.age, A.address, A.email,  A.password, B.dealing "
			+ "From user_info A LEFT JOIN order_info B ON A.user_id = B.user_id "
			+ "WHERE authority = 2 ORDER BY user_id";

		try {
			// getConnection()メソッドを利用して、Connectionオブジェクトを生成
			con = getConnection();
			// ConnectionオブジェクトのcreateStatementメソッドを利用してStatementオブジェクトを生成
			smt = con.createStatement();

			// SQLをDBへ発行
			ResultSet rs = smt.executeQuery(sql);

			// 結果セットからユーザーデータを検索件数分全て取り出し、AllayListオブジェクトにUserオブジェクトとして格納
			while (rs.next()) {
				User user = new User();
				user.setUserid(rs.getString("user_id"));
				user.setPassword(rs.getString("password"));
				user.setUsername(rs.getString("user_name"));
				user.setName(rs.getString("name"));
				user.setAddress(rs.getString("address"));
				user.setAge(rs.getInt("age"));
				user.setEmail(rs.getString("email"));
				user.setDealing(rs.getString("dealing"));
				userList.add(user);
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
		return userList;

	}

	// データベースにユーザーを登録するインスタンスメソッド
	public void insert(User user) {

		// 変数宣言
		Connection con = null;
		Statement smt = null;

		// SQL文を文字列として定義
		String sql = "INSERT INTO user_info VALUES(NULL,'"
				+ user.getPassword() + "',2,'" + user.getUsername()
				+ "','" + user.getName() + "','" + user.getAddress() + "','" + user.getAge()
				+ "','" + user.getEmail() + "')";

		try {
			// getConnection()メソッドを利用して、Connectionオブジェクトを生成
			con = getConnection();
			// ConnectionオブジェクトのcreateStatementメソッドを利用してStatementオブジェクトを生成
			smt = con.createStatement();

			// SQLをDBへ発行
			smt.executeUpdate(sql);
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
	}

	// データベースから指定されたユーザーデータを検索しUserオブジェクトに格納するインスタンスメソッド
	public User selectByUserid(String userid) {

		// 変数宣言
		Connection con = null;
		Statement smt = null;

		// return用オブジェクトの生成
		User user = new User();

		// SQL文の設定
		String sql = "SELECT * FROM bookinfo WHERE user_id = '" + userid + "'";

		try {

			// getConnectionメソッドを利用してConnectionオブジェクトを生成
			con = getConnection();
			// Connectionオブジェクトのメソッドを利用してStatementオブジェクトを生成
			smt = con.createStatement();
			// Statementオブジェクトのメソッドを利用して、SQL文を発行し結果セットを取得
			ResultSet rs = smt.executeQuery(sql);

			// 結果セットから書籍データを取り出し、Userオブジェクトに格納
			if (rs.next()) {
				user.setUserid(rs.getString("user_id"));
				user.setPassword(rs.getString("password"));
				user.setAuthority(rs.getString("authority"));
				user.setUsername(rs.getString("user_name"));
				user.setName(rs.getString("name"));
				user.setAddress(rs.getString("address"));
				user.setAge(rs.getInt("age"));
				user.setEmail(rs.getString("email"));
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
		return user;
	}

	// ユーザーデータの変更を行うメソッド
	public void update(User user) {
		// 変数宣言
		Connection con = null;
		Statement smt = null;

		// SQL文の設定
		String sql = "UPDATE user_info SET "
				+ "password = '" + user.getPassword() + "',"
				+ "user_name = '" + user.getUsername() + "',"
				+ "name = '" + user.getName() + "',"
				+ "address = '" + user.getAddress() + "',"
				+ "age = '" + user.getAge() + "',"
				+ "email = '" + user.getEmail() + "'"
				+ "WHERE user_id = '" + user.getUserid() + "'";

		try {

			// getConnectionメソッドを利用してConnectionオブジェクトを生成
			con = getConnection();
			// Connectionオブジェクトのメソッドを利用してStatementオブジェクトを生成
			smt = con.createStatement();
			// Statementオブジェクトのメソッドを利用して、SQL文を発行
			smt.executeUpdate(sql);

		} catch (

		Exception e) {
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
	}

	// ユーザーデータを削除するメソッド
	public void delete(int userid) {
		// 変数宣言
		Connection con = null;
		Statement smt = null;

		// SQL文の設定
		String sql = "DELETE FROM user_info WHERE user_id = '" + userid + "'";

		try {

			// getConnectionメソッドを利用してConnectionオブジェクトを生成
			con = getConnection();
			// Connectionオブジェクトのメソッドを利用してStatementオブジェクトを生成
			smt = con.createStatement();
			// Statementオブジェクトのメソッドを利用して、SQL文を発行
			smt.executeUpdate(sql);

		} catch (

		Exception e) {
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
	}
}
