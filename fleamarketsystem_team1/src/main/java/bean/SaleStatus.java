//作成者：畑
package bean;

public class SaleStatus {
	//① フィールド変数に定義
	
	private int product_id; //商品ID
	private String name; //商品名
	private String shipment_status;//配送状況
	
	//② コンストラクタ定義
	
	public SaleStatus(){
		
		this.product_id = 0; //商品ID初期化
		this.name = null; //商品名初期化
		this.shipment_status = null; //配送状況
		
	}
	
	//③④ 各フィールド変数のGet・setメソッド定義
	
	//商品ID
	
	public int getProduct_id() {
		return product_id;
	}

	public void setProductid(int product_id) {
		this.product_id = product_id;
	}
	
	//商品名
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	//配送状況
	
	public String getShipment_status() {
		return shipment_status;
	}
	public void setShipment_status(String shipment_status) {
		this.shipment_status = shipment_status;
	}
}