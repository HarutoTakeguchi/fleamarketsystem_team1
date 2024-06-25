/**
 * 作成：内山
 */
package bean;

public class PurchaseHistory {
	
	/**
	 * フィールド変数に定義
	 */
	//商品名
	private String name;
	//価格
	private int price;
	//個数
	private int quantity;
	//配送状況
	private String shipment_status;
	//入金状況
	private String deposit_status;
	
	/**
	 * コンストラクタ定義
	 */
	public PurchaseHistory() {
		this.name = null;
		this.price = 0;
		this.quantity = 0;
		this.shipment_status = null;
		this.deposit_status = null;
	}
	
	/**
	 * 各フィールド変数のGetメソッド定義
	 */
	public String getName() {
		return name;
	}
	
	public int getPrice() {
		return price;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public String getShipment_status() {
		return shipment_status;
	}
	
	public String getDeposit_status() {
		return deposit_status;
	}
	
	/**
	 * 各フィールド変数のSetメソッド定義
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public void setShipment_status(String shipment_status) {
		this.shipment_status = shipment_status;
	}
	
	public void setDeposit_status(String deposit_status) {
		this.deposit_status = deposit_status;
	}
	

}
