//作成者：石井

package bean;

public class Product {
	//① フィールド変数に定義

	private int productid; //商品ID
	private String userid;
	private String name; //商品名
	private int price; //商品価格
	private int quantity; //商品個数
	private String description; //商品説明文
	private String selldate; //出品日
	private String category; // 商品カテゴリ

	//② コンストラクタ定義

	public Product() {

		this.productid = 0; //商品ID初期化
		this.userid = null;
		this.name = null; //商品名初期化
		this.price = 0; //商品価格初期化
		this.quantity = 0; //商品個数初期化
		this.description = null; //商品説明文初期化
		this.selldate = null; //出品日初期化
		this.category = null;

	}

	//③④ 各フィールド変数のGet・setメソッド定義

	public int getProductid() {
		return productid;
	}

	public void setProductid(int productid) {
		this.productid = productid;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getSelldate() {
		return selldate;
	}

	public void setSelldate(String selldate) {
		this.selldate = selldate;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

}
