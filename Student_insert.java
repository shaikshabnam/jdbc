package jdbc_practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Student_insert {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		//1.load and registered driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		//2.establish connection
		Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcprc","root","root");
		
		//3.create statement
		Statement statement=connection.createStatement();
		
		//4.execute the statement
		statement.execute("insert into student values(7,'H',987654,'delhi',23456)");
		
		//5.close
		connection.close();
	}
}
