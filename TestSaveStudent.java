package jdbc_prc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class TestSaveStudent {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcprc","root","root");
			CallableStatement callablestatement = connection.prepareCall("call save_student(?,?,?,?,?)");
			callablestatement.setInt(1, 200);
			callablestatement.setString(2, "zoya");
			callablestatement.setLong(3, 12345678l);
			callablestatement.setString(4, "bnglr");
			callablestatement.setInt(5, 123);
			callablestatement.execute();
			System.out.println("data saved");
			connection.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
