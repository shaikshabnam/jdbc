package jdbc_practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Bike_delete {
	public static void main(String[] args) {
		String path="com.mysql.cj.jdbc.Driver";
		
		String url="jdbc:mysql://localhost:3306/jdbcprc";
		String username="root";
		String password="root";
		
		System.out.println("enter id which u want to delete");
		int id=new Scanner(System.in).nextInt();
		String query="delete from bike where id=?";
		//1.load and register
		try {
			Class.forName(path);
			
			//2.create connection
			try {
				Connection connection=DriverManager.getConnection(url, username, password);
				//3.create a statement
				
				PreparedStatement ps=connection.prepareStatement(query);
				ps.setInt(1, id);
				ps.execute();
				
				connection.close();
				System.out.println("saved");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
	}
}
