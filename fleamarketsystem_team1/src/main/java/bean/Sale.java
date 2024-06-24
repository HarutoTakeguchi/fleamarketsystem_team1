/**
 * 作成：内山
 */
package bean;

public class Sale {
	
	/**
	 * フィールド変数に定義
	 */
	//ユーザーID
	private int userid;
	//商品名
	private String name;
	//個数
	private int quantity;
	//金額
	private int price;
	//売上日
	private String solddate;
	
	/**
	 * 引数なしコンストラクタ定義(初期化)
	 */
	public Sale() {
		this.userid = 0;
		this.name = null;
		this.quantity = 0;
		this.price = 0;
		this.solddate = null;
	}
	
	/**
	 * 各フィールド変数のGetメソッド定義
	 */
	public int getUser_id() {
		return userid;
	}
	
	public String getName() {
		return name;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public int getPrice() {
		return price;
	}
	
	public String getSold_date() {
		return solddate;
	}
	
	/**
	 * 各フィールド変数のSetメソッド定義
	 */
	public void setUser_id(int userid) {
		this.userid = userid;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
	
	public void setSold_date(String solddate) {
		this.solddate = solddate;
	}

}
