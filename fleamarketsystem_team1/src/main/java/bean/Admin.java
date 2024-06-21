// 作成者:畑

//多分必要ない

package bean;

public class Admin{
	
//① フィールド変数に定義
private int admin_id;  //管理者ID
private String password;//パスワード

//② コンストラクタ定義
public Admin(){
	this.admin_id = 0 ; //管理者ID初期化
	this.password = null ; //パスワード初期化
}

//③④ 各フィールド変数のGet・setメソッド定義
public int getAdmin_id() {
		return admin_id;
	}

public void setAdmin_id(int admin_id) {
		this.admin_id = admin_id  ;
	}

public String getPassword() {
		return  password;
	}

public void setPassword(String password) {
		this.password = password  ;
	}
}

