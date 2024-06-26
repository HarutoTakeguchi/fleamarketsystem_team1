//作成者：内山

package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import bean.Product;

public class ProductDAO {

	//JDBCドライバ内部のDriverクラスパス
	private static String RDB_DRIVE = "org.mariadb.jdbc.Driver";

	//接続するMySQLデータベース
	private static String URL = "jdbc:mariadb://localhost/marketdb";

	//データベースのユーザー名
	private static String USER = "root";

	//データベースのパスワード
	private static String PASSWD = "root123";

	/**
	 * DB接続を行うメソッド定義
	 */
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

	/**
	 * 全商品情報を取得するメソッド
	 */
	public ArrayList<Product> selectAll() {

		Connection con = null;
		Statement smt = null;

		ArrayList<Product> list = new ArrayList<Product>();

		try {

			con = getConnection();
			smt = con.createStatement();

			String sql = "SELECT * FROM product_info";

			ResultSet rs = smt.executeQuery(sql);

			while (rs.next()) {
				Product product = new Product();
				product.setProductid(rs.getInt("product_id"));
				product.setName(rs.getString("name"));
				product.setPrice(rs.getInt("price"));
				product.setQuantity(rs.getInt("quantity"));
				product.setDescription(rs.getString("description"));
				product.setSelldate(rs.getString("sell_date"));
				product.setCategory(rs.getString("category"));
				list.add(product);
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
		return list;
	}

	/**
	 * 条件から合致する商品情報を取得するメソッド
	 */
	public Product selectByProduct(String productId) {

		Connection con = null;
		Statement smt = null;

		//戻り値の設定
		Product product = new Product();

		try {

			//getConnection()メソッドを利用してConnectionオブジェクトを生成
			con = getConnection();

			//createStatement()メソッドを利用してStatementoオブジェクトを生成
			smt = con.createStatement();

			//SQL文を文字列として定義
			String sql = "SELECT * FROM product_info WHERE product_id ='" + productId + "'";

			ResultSet rs = smt.executeQuery(sql);

			if (rs.next()) {
				product.setProductid(rs.getInt("product_id"));
				product.setUserid(rs.getString("user_id"));
				product.setName(rs.getString("name"));
				product.setPrice(rs.getInt("price"));
				product.setQuantity(rs.getInt("quantity"));
				product.setDescription(rs.getString("description"));
				product.setSelldate(rs.getString("sell_date"));
				product.setCategory(rs.getString("category"));
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
		return product;
	}

	/**
	 * 商品情報の新規登録を行うメソッド
	 */
	public void insert(Product product) {

		Connection con = null;
		Statement smt = null;

		// SQL文を文字列として定義
		String sql = "INSERT INTO product_info VALUES(NULL," + product.getUserid()
				+ ",'" + product.getName() + "','"
				+ product.getPrice() + "','" + product.getQuantity() + "','"
				+ product.getDescription() + "','" + product.getSelldate() + "','"
				+ product.getCategory() + "')";

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

	/**
	 * 商品情報を削除するメソッド
	 */
	public void delete(String productid) {

		Connection con = null;
		Statement smt = null;

		try {

			//getConnection()メソッドを利用してConnectionオブジェクトを生成
			con = getConnection();

			//createStatement()メソッドを利用してStatementオブジェクトを生成
			smt = con.createStatement();

			//SQLを文字列として定義
			String sql = "DELETE FROM product_info WHERE product_id = '" + productid + "'";

			//SQL文を発行
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
	
	/**
	 * 出品情報を取得するメソッド
	 */
	public ArrayList<Product> selectBySale(String user_id) {
		
		Connection con = null;
		Statement smt = null;
		
		ArrayList<Product> list = new ArrayList<Product>();
		
		try {

			//getConnection()メソッドを利用してConnectionオブジェクトを生成
			con = getConnection();

			//createStatement()メソッドを利用してStatementoオブジェクトを生成
			smt = con.createStatement();		
			

			//SQL文を文字列として定義
			String sql = "select product_id,name from product_info where user_id = " + user_id;
			
			//SQL文を発行し結果セットを取得する
			ResultSet rs = smt.executeQuery(sql);
			
			//結果セットからデータを取り出して、Productオブジェクトに格納する
			while(rs.next()) {
				Product Product = new Product();
				Product.setProductid(rs.getInt("product_id"));
				Product.setName(rs.getString("name"));
				list.add(Product);
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
