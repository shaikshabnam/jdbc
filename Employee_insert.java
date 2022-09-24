package jdbc_practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Employee_insert {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		//1.load and register Driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		//2.establish connection
		Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcprc","root","root");
		
		//3.create statement
		Statement statement=connection.createStatement();
		
		//4.execute querry
		statement.execute("insert into employee values (5,'e',5678901234,'efg','gfe','v',3,'rani banglaw')");
		
		//5.close
		connection.close();
	}
}
