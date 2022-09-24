package jdbc_prc;

import java.util.Scanner;

public class Mobile_driver {
	public static void main(String[] args) {
		
		Mobile m=new Mobile();
		Mobile_DAO md=new Mobile_DAO();
		
		Scanner s=new Scanner(System.in);
		System.out.println("enter a number");
		int n=s.nextInt();
		switch(n) {
		case 1:{
			System.out.println("enter id");
			int id=s.nextInt();
			System.out.println("enter name");
			String name=s.next();
			System.out.println("enter brand");
			String brand=s.next();
			System.out.println("enter colour");
			String colour=s.next();
			System.out.println("enter price");
			double price=s.nextDouble();
			System.out.println("enter ram");
			int ram=s.nextInt();
			System.out.println("enter manufacturer");
			String manufacturer=s.next();
			
			m.setId(id);
			m.setName(name);
			m.setBrand(brand);
			m.setColour(colour);
			m.setPrice(price);
			m.setRam(ram);
			m.setManufacturer(manufacturer);
			
			md.insertMobile(m);
			break;
		}
		case 2:{
			System.out.println("enter id");
			int id=s.nextInt();
			System.out.println("enter name");
			String name=s.next();
			System.out.println("enter brand");
			String brand=s.next();
			System.out.println("enter colour");
			String colour=s.next();
			System.out.println("enter price");
			double price=s.nextDouble();
			System.out.println("enter ram");
			int ram=s.nextInt();
			System.out.println("enter manufacturer");
			String manufacturer=s.next();
			
			m.setId(id);
			m.setName(name);
			m.setBrand(brand);
			m.setColour(colour);
			m.setPrice(price);
			m.setRam(ram);
			m.setManufacturer(manufacturer);
			
			md.updateMobile(m);
		}
		}
	}
}
