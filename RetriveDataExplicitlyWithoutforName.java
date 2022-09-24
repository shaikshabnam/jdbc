package jdbc_practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.mysql.cj.jdbc.Driver;

public class RetriveDataExplicitlyWithoutforName {
	public static void main(String[] args) {
		try{
		com.mysql.cj.jdbc.Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		
		Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcprc", "root", "root");
		
		Statement statement=connection.createStatement();
		
		ResultSet resultset=statement.executeQuery("select * from employee where floor=2");
		while(resultset.next()) {
			System.out.println(resultset.getInt(1));
			System.out.println(resultset.getString(2));
			System.out.println(resultset.getLong(3));
			System.out.println(resultset.getString(4));
			System.out.println(resultset.getString(5));
			System.out.println(resultset.getString(6));
			System.out.println(resultset.getInt(7));
			System.out.println(resultset.getString(8));
			System.out.println("****************");
		}
		statement.close();
		connection.close();
	}
	 catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
}
