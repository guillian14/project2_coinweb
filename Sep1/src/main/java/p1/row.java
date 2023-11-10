package p1;
public class row {
	private String product_id;
	private String product_name;
	private String product_desc;
	private String image;
	private Integer qty;
	private float total_price;
	private float product_price;
	private Integer qtyOrder;
	private Integer product_qty_available;
	/*public row(String product_id, String product_name, String product_desc, String image, Integer qty,
	float product_price, float total_price) {
		this.product_id = product_id;
		this.product_name = product_name;
		this.product_desc = product_desc;
		this.image = image;
		this.qty = qty;
		this.product_price = product_price;
		this.total_price = total_price;
	}*/
	public row(String product_id, String product_name, String product_desc, String image, Integer qty,
	float product_price, Integer product_qty_available) {
		this.product_id = product_id;
		this.product_name = product_name;
		this.product_desc = product_desc;
		this.image = image;
		this.qty = qty;
		this.product_price = product_price;
		this.product_qty_available = product_qty_available;
	}
	public String get_product_id() {
		return product_id;
	}
	public void set_product_id(String product_id) {
		this.product_id = product_id;
	}
	public String get_product_name() {
		return product_name;
	}
	public void set_product_name(String product_name) {
		this.product_name = product_name;
	}
	public String get_product_desc() {
		return product_desc;
	}
	public void set_product_desc(String product_desc) {
		this.product_desc = product_desc;
	}
	public String get_image() {
		return image;
	}
	public void set_image(String image) {
		this.image = image;
	}
	/*public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}*/
	public Integer get_qty() {
		return qty;
	}
	public void set_qty(Integer qty) {
		this.qty = qty;
	}
	public float get_product_price() {
		return product_price;
	}
	public void set_product_price(float product_price) {
		this.product_price = product_price;
	}
	/*public float getImportedPrice() {
		return importedPrice;
	}
	public void setImportedPrice(float importedPrice) {
		this.importedPrice = importedPrice;
	}*/
	public Integer get_product_qty_available() {
		return product_qty_available;
	}
	public void set_product_qty_available(Integer product_qty_available) {
		this.product_qty_available = product_qty_available;
	}
}
