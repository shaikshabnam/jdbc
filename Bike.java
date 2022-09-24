package jdbc_practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Bike {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Scanner s=new Scanner(System.in);
		System.out.println("enter id");
		int id=s.nextInt();
		System.out.println("enter name");
		String name=s.next();
		System.out.println("enter manufacturer");
		String manufacturer=s.next();
		System.out.println("enter milage");
		int milage=s.nextInt();
		System.out.println("enter address");
		String address=s.next();
		System.out.println("enter model");
		String model=s.next();
		
		String path="com.mysql.cj.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/jdbcprc";
		String username="root";
		String password="root";
		
		//1.load and register
		Class.forName(path);
		
		//2. establish connection
		Connection connection=DriverManager.getConnection(url, username, password);
		
		String query="insert into bike values(?,?,?,?,?,?)";
		//3.create statement
		PreparedStatement preparedstatement=connection.prepareStatement(query);
		
		preparedstatement.setInt(1, id);
		preparedstatement.setString(2, name);
		preparedstatement.setString(3, manufacturer);
		preparedstatement.setInt(4, milage);
		preparedstatement.setString(5, address);
		preparedstatement.setString(6, model);
		
		preparedstatement.execute();
		
		preparedstatement.close();
		connection.close();
	}
}
