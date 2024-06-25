//作成者：畑
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import bean.SaleStatus;

public class SaleStatusDAO {

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

	//DBのorderinfoとuserinfoテーブルを結合して出品状況情報を取得するメソッド定義
	public ArrayList<SaleStatus> selectBySaleStatus(){

		Connection con = null;
		Statement smt = null;

		SaleStatus saleStatusObj = new SaleStatus();

		//戻り値の設定
		ArrayList<SaleStatus> list = new ArrayList<SaleStatus>();

		try {

			//getConnection()メソッドを利用してConnectionオブジェクトを生成
			con = getConnection();

			//createStatement()メソッドを利用してStatementoオブジェクトを生成
			smt = con.createStatement();		
			

			//SQL文を文字列として定義
			String sql = "select p.product_id,p.name,o.shipment"
					+ "from product_info p inner join order_info o on p.product_id = o.product_id";
			
			//SQL文を発行し結果セットを取得する
			ResultSet rs = smt.executeQuery(sql);
			
			//結果セットからデータを取り出して、Saleオブジェクトに格納する
			while(rs.next()) {
				
				saleStatusObj.setProductid(rs.getInt("product_id"));
				saleStatusObj.setName(rs.getString("name"));
				saleStatusObj.setShipment_status(rs.getString("shipment_status"));
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
