//作成：竹口

package bean;

public class SaleList {

	private String userid; //ユーザーID
	private String username ;//ユーザー名
	private String productname; //商品名
	private int quantity; //販売数量
	private int price; //価格
	private String selldate; //出品日
	private String dealing; //取引状況

	// コンストラクタ定義
	public SaleList() {
		this.userid = null;
		this.username = null;
		this.productname = null;
		this.quantity = 0;
		this.price = 0;
		this.selldate = null;
		this.dealing = null;
	}

	// アクセサメソッド定義
	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getSelldate() {
		return selldate;
	}

	public void setSelldate(String selldate) {
		this.selldate = selldate;
	}

	public String getDealing() {
		return dealing;
	}

	public void setDealing(String dealing) {
		this.dealing = dealing;
	}

}