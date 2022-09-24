package jdbc_prc;

public class Mobile {

	private int id;
	private String name;
	private String brand;
	private String colour;
	private double price;
	private int ram;
	private String manufacturer;
	
	public Mobile() {
		super();
	}

	public Mobile(int id, String name, String brand, String colour, double price, int ram, String manufacturer) {
		super();
		this.id = id;
		this.name = name;
		this.brand = brand;
		this.colour = colour;
		this.price = price;
		this.ram = ram;
		this.manufacturer = manufacturer;
	}

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

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getRam() {
		return ram;
	}

	public void setRam(int ram) {
		this.ram = ram;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	
	
	
}
