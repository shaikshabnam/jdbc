package jdbc_prc;

import java.util.Scanner;

public class DAO_Driver {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		DAO dao=new DAO();
		boolean b=true;
		do 
	{
			System.out.println();
		System.out.println("enter a value \n1.insert \n2.update \n3.delete \n4.get \n5.exit");
		System.out.println();
		int n=scanner.nextInt();
		switch(n) {
		case 1	:{
			System.out.println("***************");
			System.out.println("enter insert id");
		int id=scanner.nextInt();
		System.out.println("enter insert name");
		String name=scanner.next();
		System.out.println("enter insert address");
		String address=scanner.next();
		System.out.println("enter insert phone number");
		long phone=scanner.nextLong();
		System.out.println("enter insert pincode");
		int pincode=scanner.nextInt();
	
		String result=dao.savePerson(id, name, address, phone, pincode);
		System.out.println(result);
		}
		break;
		
		case 2:{
			System.out.println("**************");
			System.out.println("enter id whose name want to update");
			int id=scanner.nextInt();
			System.out.println("enter update name");
			String name=scanner.next();
			String address
		
			String result=dao.updatePerson(id,name,address, phone, pin);
		    System.out.println(result);
		    break;
		}
		
		case 3:{
			System.out.println("***************");
			System.out.println("enter id which row u want to delete");
			int id=scanner.nextInt();
			String result=dao.deletePerson(id);
			System.out.println(result);
			break;
		}
		case 4:
		{
			System.out.println("***************");
			System.out.println("enter id which row u want to get");
			int id=scanner.nextInt();
			String result=dao.getPerson(id);
			
			break;
		}
		case 5:
			b=false;
			System.out.println("exited ");
		}
	}
		while(b);
	}
}
