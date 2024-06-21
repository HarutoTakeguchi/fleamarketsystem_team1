//作成者：小澤

package bean;

public class OrderedItem {
	
	private String userid;//購入したユーザーのID
	
	private String order_no;//購入された商品の番号
	
	private String product_id;//購入された商品のID
	
	private String sold_date;//購入日付
	
	private String dealing;//取引状況ステータス
	
	private String deposit_status;//入金状況
	
	private String shipment_status;//配送状況
	//コンストラクタ
	
	public OrderedItem() {
		this.userid = null;
		this.order_no = null;
		this.product_id =null;
		this.sold_date = null;
		this.dealing = null;
		this.deposit_status = null;
		this.shipment_status = null;
	}
	
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getOrder_no() {
		return order_no;
	}
	public void setOrder_no(String order_no) {
		this.order_no = order_no;
	}

	public String getSold_date() {
		return sold_date;
	}
	public void setSold_date(String sold_date) {
		this.sold_date = sold_date;
	}

	public String getDeposit_status() {
		return deposit_status;
	}
	public void setDeposit_status(String deposit_status) {
		this.deposit_status = deposit_status;
	}
	
	public String getProduct_id() {
		return product_id;
	}
	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}
	
	public String getDealing() {
		return dealing;
	}
	public void setDealing(String dealing) {
		this.dealing = dealing;
	}
	
	public String getShipment_status() {
		return shipment_status;
	}
	public void setShipment_status(String shipment_status) {
		this.shipment_status = shipment_status;
	}

}