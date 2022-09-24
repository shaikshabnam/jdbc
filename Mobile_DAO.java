package jdbc_prc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Mobile_DAO {

	String path="com.mysql.cj.jdbc.Driver";
	Connection connection=null;
	String url="jdbc:mysql://localhost:3306/jdbcprc";
	String username="root";
	String password="root";
	
	public Mobile insertMobile(Mobile m) {
		String query="insert into Mobile values(?,?,?,?,?,?,?)";
		try {
			Class.forName(path);
			connection=DriverManager.getConnection(url, username, password);
			PreparedStatement preparedstatement=connection.prepareStatement(query);
			
			preparedstatement.setInt(1, m.getId());
			preparedstatement.setString(2, m.getName());
			preparedstatement.setString(3, m.getBrand());
			preparedstatement.setString(4, m.getColour());
			preparedstatement.setDouble(5, m.getPrice());
			preparedstatement.setInt(6, m.getRam());
			preparedstatement.setString(7, m.getManufacturer());
			
			preparedstatement.execute();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return m;
	}
	
	public Mobile updateMobile(Mobile m) {
		
		String query="update mobile set name=?,brand=?,colour=?,price=?,ram=?,manufacturer=? where id=?";
		try {
			Class.forName(path);
			connection=DriverManager.getConnection(url, username, password);
			PreparedStatement preparedStatement=connection.prepareStatement(query);
			
			preparedStatement.setString(1, m.getName());
			preparedStatement.setString(2, m.getBrand());
			preparedStatement.setString(3, m.getColour());
			preparedStatement.setDouble(4, m.getPrice());
			preparedStatement.setInt(5, m.getRam());
			preparedStatement.setString(6, m.getManufacturer());
			preparedStatement.setInt(7, m.getId());
			
			preparedStatement.execute();
					
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return m;
	}
	public Mobile getMobile(Mobile m) {
		String query="select * from mobile where id=?";
		try {
			Class.forName(path);
			connection=DriverManager.getConnection(url, username, password);
			PreparedStatement preparedStatement=connection.prepareStatement(query);
			
		
				ResultSet resultset=preparedStatement.executeQuery();
				if(resultset!=null) {
					preparedStatement.setInt(1,m.getId());
					
				}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return m;
	}
}
