//作成者：石井

package dao;

import java.sql.Connection;
import java.sql.DriverManager;
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
			String sql = "INSERT INTO orderinfo VALUES(NULL,'"+ product.getUserid() + "','"+ product.getProductid() + "','"+"',CURDATE()"+"','"+0+"','"
					+ 0 +"','+ 0)";
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
}