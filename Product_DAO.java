package jdbc_prc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Product_DAO {
	String path="com.mysql.cj.jdbc.Driver";
	Connection connection=null;
	String url="jdbc:mysql://localhost:3306/jdbcprc";
	String username="root";
	String password="root";
	
	public Product setProduct(Product p) {
		String query="insert into product values(?,?,?,?,?,?,?,?)";
		try {
			Class.forName(path);
			connection=DriverManager.getConnection(url, username, password);
			PreparedStatement preparedstatement=connection.prepareStatement(query);
			
			preparedstatement.setInt(1, p.getId());
			preparedstatement.setString(2, p.getName());
			preparedstatement.setDouble(3, p.getPrice());
			preparedstatement.setString(4, p.getManufacturer());
			preparedstatement.setDouble(5, p.getDiscount());
			preparedstatement.setInt(6, p.getWarranty());
			preparedstatement.setString(7, p.getManufacturer_date());
			preparedstatement.setDouble(8, p.getGst());
			
			preparedstatement.executeUpdate();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(connection!=null)
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		return p;
	}
	
	public Product updateProduct(Product p) {
		
		String query="update product set name=?,price=?,Manufacturer=?,discount=?,warranty=?,Manufacturer_date=?,gst=? where id=?";
		try {
			Class.forName(path);
			connection=DriverManager.getConnection(url, username, password);
			PreparedStatement preparedstatement=connection.prepareStatement(query);
			
			preparedstatement.setInt(8, p.getId());
			preparedstatement.setString(1, p.getName());
			preparedstatement.setDouble(2, p.getPrice());
			preparedstatement.setString(3, p.getManufacturer());
			preparedstatement.setDouble(4, p.getDiscount());
			preparedstatement.setInt(5, p.getWarranty());
			preparedstatement.setString(6, p.getManufacturer_date());
			preparedstatement.setDouble(7, p.getGst());
			
			preparedstatement.executeUpdate();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(connection!=null)
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		return p;
	}
	public String  deleteProduct(int id) {
		String query="delete from product where id=?";
		try {
			Class.forName(path);
			connection=DriverManager.getConnection(url, username, password);
			PreparedStatement preparedstatement=connection.prepareStatement(query);
			
			preparedstatement.setInt(1, id);
			
			preparedstatement.execute();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(connection!=null)
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		return "deleted";
	}
	public Product getProduct(Product p) {
		String query="select * from product where id=?";
			
		try {
			Class.forName(path);
			connection=DriverManager.getConnection(url, username, password);
			PreparedStatement preparedstatement=connection.prepareStatement(query);
			
			preparedstatement.setInt(1, p.getId());
			
			ResultSet resultset=preparedstatement.executeQuery();
			
			while(resultset.next()) {
				p.setId(resultset.getInt(1));
				p.setName(resultset.getString(2));
				p.setPrice(resultset.getDouble(3));
				p.setManufacturer(resultset.getString(4));
				p.setDiscount(resultset.getDouble(5));
				p.setWarranty(resultset.getInt(6));
			    p.setManufacturer_date(resultset.getString(7));
				p.setGst(resultset.getDouble(8));
				return p;
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(connection!=null)
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		
		return null;
	}
	public List<Product> getAllProducts() {
		String query="select * from product";
		List<Product> list=new ArrayList();

		try {
			Class.forName(path);
			connection=DriverManager.getConnection(url, username, password);
			PreparedStatement preparedStatement=connection.prepareStatement(query);
			
			ResultSet resultset=preparedStatement.executeQuery();
			
			
			while(resultset.next()) {
				Product product=new Product();
				product.setId(resultset.getInt(1));
				product.setName(resultset.getString(2));
				product.setPrice(resultset.getDouble(3));
				product.setManufacturer(resultset.getString(4));
				product.setDiscount(resultset.getDouble(5));
				product.setWarranty(resultset.getInt(6));
			    product.setManufacturer_date(resultset.getString(7));
				product.setGst(resultset.getDouble(8));
				
				list.add(product);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}
