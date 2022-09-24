package jdbc_prc;

import java.util.List;
import java.util.Scanner;

public class ProductDriver {
	public static void main(String[] args) {
		
		Product p=new Product();
		Product_DAO pd=new Product_DAO();
		Scanner s=new Scanner(System.in);
		boolean flag=true;
		while(flag) {
			System.out.println();
		System.out.println("enter a value to get\n \n1.insert \n2.update \n3.delete \n4.get \n5.exit");
		int n=s.nextInt();
		switch(n) {
		case 1:{
			System.out.println("enter id to insert");
			int id=s.nextInt();
			System.out.println("enter name to insert");
			String name=s.next();
			System.out.println("enter price to insert");
			double price=s.nextDouble();
			System.out.println("enter manufacturer to insert");
			String manufacturer=s.next();
			System.out.println("enter discount to insert");
			double discount=s.nextDouble();
			System.out.println("enter warranty to insert");
			int warranty=s.nextInt();
			System.out.println("enter manufacturer date to insert");
			String manufacturer_date=s.next();
			System.out.println("enter GST to insert");
			double gst=s.nextDouble();
			
			p.setId(id);
			p.setName(name);
			p.setPrice(price);
			p.setManufacturer(manufacturer);
			p.setDiscount(discount);
			p.setWarranty(warranty);
			p.setManufacturer_date(manufacturer_date);
			p.setGst(gst);
			
			pd.setProduct(p);
			break;
		}
		case 2:{
			System.out.println("enter id to update");
			int id=s.nextInt();
			System.out.println("enter name to update");
			String name=s.next();
			System.out.println("enter price to update");
			double price=s.nextDouble();
			System.out.println("enter manufacturer to update");
			String manufacturer=s.next();
			System.out.println("enter discount to update");
			double discount=s.nextDouble();
			System.out.println("enter warranty to update");
			int warranty=s.nextInt();
			System.out.println("enter manufacturer date to update");
			String manufacturer_date=s.next();
			System.out.println("enter GST to update");
			double gst=s.nextDouble();
			
			p.setId(id);
			p.setName(name);
			p.setPrice(price);
			p.setManufacturer(manufacturer);
			p.setDiscount(discount);
			p.setWarranty(warranty);
			p.setManufacturer_date(manufacturer_date);
			p.setGst(gst);
			
			pd.updateProduct(p);
			System.out.println("---updated succesfully---");
			break;
		}
		case 3:{
			System.out.println("enter id which row u want to delete");
			int id=s.nextInt();
			pd.deleteProduct(id);
			System.out.println("---deleted successfully---");
			break;
		}
		case 4:{
			System.out.println("enter id which u want to see");
			int id=s.nextInt();
			p.setId(id);
			Product product=pd.getProduct(p);
	//		 Product po=pd.getProduct(p);
	System.out.println("product id is :"+product.getId());
			System.out.println("product name is :"+product.getName());
			System.out.println("product price is :"+product.getPrice());
			System.out.println("product manufacturer is :"+product.getManufacturer());
			System.out.println("product discount is :"+product.getDiscount());
			System.out.println("product warranty is :"+product.getWarranty());
			System.out.println("product manufacturing date is :"+product.getManufacturer_date());
			System.out.println("product GST is :"+product.getGst());
			System.out.println();
			// System.out.println(po);
			break;
		}
		case 5:flag=false;
			System.out.println("exited");
			System.out.println("---thank you---");
			break;
		
		case 6:
			List<Product> list=pd.getAllProducts();
			for(Product value:list) {
				System.out.println(value);
			}
		}
		}
	}
}
