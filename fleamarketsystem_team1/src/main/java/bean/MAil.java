package bean;

public class MAil {
	
	private String mail;

	//② コンストラクタ定義
	public MAil(){
		this.mail = null ; //パスワード初期化
}
	
	public void setMail(String mail) {
		
		this.mail = mail;
	}
	
	public String getMail() {
		return mail;
	}
}