package jdbc_practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Driver {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		//load and register
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		//establish the connection
		Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcprc","root","root");
		
		// create the statement
		Statement st=connection.createStatement();
		
		//execute a querry
		st.execute("insert into emp values(2,'a')");
		
		//close
		connection.close();
		System.out.println("saved");
	}
}
