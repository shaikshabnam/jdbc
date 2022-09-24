package jdbc_prc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MobileBatch {
	public static void main(String[] args) {
		
		List<Mobile> list=new ArrayList();
		Mobile mobile=new Mobile();
		Mobile mobile1=new Mobile(2,"a","z","black",123,2,"abc");
		Mobile mobile2=new Mobile(3,"b","z","blue",543,2,"abc");
		Mobile mobile3=new Mobile(4,"c","s","blue",234,4,"xyz");
		
		list.add(mobile1);
		list.add(mobile2);
		list.add(mobile3);
		
	
		String path="com.mysql.cj.jdbc.Driver";
		Connection connection=null;
		String url="jdbc:mysql://localhost:3306/jdbcprc";
		String username="root";
		String password="root";
		String query="insert into mobile values(?,?,?,?,?,?,?)";
		try {
			Class.forName(path);
			connection=DriverManager.getConnection(url, username, password);
			PreparedStatement preparedstatement=connection.prepareStatement(query);
			
			for(Mobile value:list) {
				preparedstatement.setInt(1, value.getId());
				preparedstatement.setString(2, value.getName());
				preparedstatement.setString(3, value.getBrand());
				preparedstatement.setString(4, value.getColour());
				preparedstatement.setDouble(5, value.getPrice());
				preparedstatement.setInt(6, value.getRam());
				preparedstatement.setString(7, value.getManufacturer());
				
				preparedstatement.addBatch();
			}
			preparedstatement.executeBatch();
			System.out.println(list);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
