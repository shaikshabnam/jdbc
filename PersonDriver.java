package jdbc_prc;

import java.util.Scanner;

public class PersonDriver {
	
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		System.out.println("enter insert id");
		int id=scanner.nextInt();
		Person p=new Person();
		DAO dao=new DAO();
		dao.getPersonObj(id);
		
	}
}
