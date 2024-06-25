//作成者：石井

package bean;

public class User {
	//① フィールド変数に定義

	private String user_id; //ユーザーID
	private String password; //パスワード
	private String authority; //権限
	private String user_name; //ユーザーネーム
	private String name; //本名
	private String address; //住所
	private int age; //年齢
	private String email; //メールアドレス
	private String dealing; // 取引状況

	//② コンストラクタ定義

	public User(){

	this.user_id = null ; //ユーザーID初期化
	this.password = null ; //パスワード初期化
	this.authority = null ; //権限初期化
	this.user_name = null ; //ユーザーネーム初期化
	this.name = null ; //本名初期化
	this.address = null ; //住所初期化
	this.age = 0 ; //年齢初期化
	this.email = null; //メールアドレス初期化
	this.dealing = null;
	}

	//③④ 各フィールド変数のGet・setメソッド定義

	//ユーザーID

	public String getUserid() {
		return user_id;
	}

	public void setUserid(String user_id) {
		this.user_id = user_id;
	}

	//パスワード

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	//権限

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	//ユーザーネーム

	public String getUsername() {
		return user_name;
	}

	public void setUsername(String user_name) {
		this.user_name = user_name;
	}

	//本名

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	//住所

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	//年齢

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	//メールアドレス

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getDealing() {
		return dealing;
	}
	public void setDealing(String dealing) {
		this.dealing = dealing;
	}
	
}
