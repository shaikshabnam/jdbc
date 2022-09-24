package com.ty.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ty.dto.Cart;

public class Cart_DAO {
	
	String path="com.mysql.cj.jdbc.Driver";
	Connection connection=null;
	String url="jdbc:mysql://localhost:3306/jdbcprc";
	String username="root";
	String password="root";
	
	public Cart saveCart(Cart c) {
		String query="insert into cart values(?,?,?,?,?)";
		try {
			Class.forName(path);
			connection=DriverManager.getConnection(url,username,password);
			PreparedStatement preparedStatement=connection.prepareStatement(query);
			
			preparedStatement.setInt(1, c.getId());
			preparedStatement.setString(2, c.getEmail());
			preparedStatement.setString(3, c.getPassword());
			preparedStatement.setString(4, c.getUsername());
			preparedStatement.setString(5, c.getAddress());
			
			preparedStatement.execute();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if (connection!=null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return c;
	}
	public Cart updateCart(Cart c) {
		String query="update cart set email=?,password=?,username=?,address=? where id=?";
		try {
			Class.forName(path);
			connection=DriverManager.getConnection(url,username,password);
			PreparedStatement preparedStatement=connection.prepareStatement(query);
			
			preparedStatement.setString(1, c.getEmail());
			preparedStatement.setString(2, c.getPassword());
			preparedStatement.setString(3, c.getUsername());
			preparedStatement.setString(4, c.getAddress());
			preparedStatement.setInt(5, c.getId());
			
			preparedStatement.execute();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if (connection!=null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return c;	
	}
	
	public String deleteCart(int id) {
		String query="delete from cart where id=?";
		try {
			Class.forName(path);
			connection=DriverManager.getConnection(url,username,password);
			PreparedStatement preparedStatement=connection.prepareStatement(query);
			
			preparedStatement.setInt(1,id);
			
			preparedStatement.execute();
			
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
	
	public Cart getCart(Cart c) {
		String query="select * from cart where id=?";
		try {
			Class.forName(path);
			connection=DriverManager.getConnection(url,username,password);
			PreparedStatement preparedStatement=connection.prepareStatement(query);
			
			preparedStatement.setInt(1, c.getId());
			ResultSet resultset= preparedStatement.executeQuery();
			while (resultset.next()) {
				c.setId(resultset.getInt(1));
				c.setEmail(resultset.getString(2));
				c.setPassword(resultset.getString(3));
				c.setUsername(resultset.getString(4));
				c.setAddress(resultset.getString(5));
				
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
		return c;
	}
	public List<Cart> getAllCart(){
		String query="select * from cart";
		try {
			Class.forName(path);
			connection=DriverManager.getConnection(url,username,password);
			PreparedStatement preparedStatement=connection.prepareStatement(query);
			ResultSet resultSet= preparedStatement.executeQuery();
			List<Cart> list=new ArrayList();
			Cart c=new Cart();
			while(resultSet.next()) {
				c.setId(resultSet.getInt(1));
				c.setEmail(resultSet.getString(2));
				c.setPassword(resultSet.getString(3));
				c.setUsername(resultSet.getString(4));
				c.setAddress(resultSet.getString(5));
				
				list.add(c);
			}
			return list;
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(connection!=null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
		
	}
	
}
