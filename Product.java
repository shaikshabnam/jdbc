package jdbc_prc;

public class Product {
	private int id;
	private String name;
	private double price;
	private String manufacturer;
	private double discount;
	private int warranty;
	private String manufacturer_date;
	private double gst;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double d) {
		this.price = d;
	}
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	public double getDiscount() {
		return discount;
	}
	public void setDiscount(double discount) {
		this.discount = discount;
	}
	public int getWarranty() {
		return warranty;
	}
	public void setWarranty(int warranty) {
		this.warranty = warranty;
	}
	public String getManufacturer_date() {
		return manufacturer_date;
	}
	public void setManufacturer_date(String manufacturer_date) {
		this.manufacturer_date = manufacturer_date;
	}
	public double getGst() {
		return gst;
	}
	public void setGst(double gst) {
		this.gst = gst;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + ", manufacturer=" + manufacturer
				+ ", discount=" + discount + ", warranty=" + warranty + ", manufacturer_date=" + manufacturer_date
				+ ", gst=" + gst + "]";
	}
	
	
}
