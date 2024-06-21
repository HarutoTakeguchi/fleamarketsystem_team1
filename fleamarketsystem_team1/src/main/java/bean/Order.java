//作成者：後藤

package bean;

/*
 * 注文情報（オーダーNo、ユーザーID、書籍のISBN、購入する書籍数、購入日付）を 一つのオブジェクトとしてまとめるためのDTOクラス
 */
public class Order {

	/**
	 * 購入するユーザーのID
	 */
	private String userid;
	/**
	 * 購入する商品のID
	 */
	private String productid;
	/**
	 * 購入する商品数
	 */
	private int quantity;
	/**
	 * 売上日
	 */
	private String solddate;

	/**
	 * コンストラクタ<br>
	 * 注文情報（商品ID、ユーザーID、商品数、売上日）の初期設定をおこなう
	 */
	public Order() {
		this.userid = null;
		this.productid = null;
		this.quantity = 0;
		this.solddate = null;
	}

	/**
	 * 購入するユーザーのIDを取得する
	 *
	 * @return 購入するユーザーのID
	 */
	public String getUserid() {
		return userid;
	}

	/**
	 * 購入するユーザーのIDを設定する
	 *
	 * @param userid
	 *            設定するユーザーID
	 */
	public void setUserid(String userid) {
		this.userid = userid;
	}

	/**
	 * 購入する商品IDを取得する
	 *
	 * @return 購入する商品ID
	 */
	public String getProductid() {
		return productid;
	}

	/**
	 * 購入する商品IDを設定する
	 *
	 * @param isbn
	 *            設定する商品ID
	 */
	public void setProductid(String productid) {
		this.productid = productid;
	}

	/**
	 * 購入する商品数を取得する
	 *
	 * @return 購入する商品数
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * 購入する商品数を設定する
	 *
	 * @param quantity
	 *            設定する商品数
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	/**
	 * 売上日付を取得する
	 *
	 * @return 売上日付
	 */
	public String getSolddate() {
		return solddate;
	}

	/**
	 * 購入日付を設定する
	 *
	 * @param date
	 *            設定する購入日付
	 */
	public void setSolddate(String solddate) {
		this.solddate = solddate;
	}
}