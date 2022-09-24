package jdbc_prc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestStudentWhere {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcprc","root","root");
			CallableStatement callableStatement=con.prepareCall("call get_studentwhere(?)");
			callableStatement.setInt(1, 3);
			ResultSet resultset=callableStatement.executeQuery();
			
			while(resultset.next()) {
				System.out.println( resultset.getInt(1));
				System.out.println( resultset.getString(2));
				System.out.println( resultset.getLong(3));
				System.out.println( resultset.getString(4));
				System.out.println( resultset.getInt(5));
				
			}
			System.out.println();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
