package jdbc_prc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAO {
	String path="com.mysql.cj.jdbc.Driver";
	Connection connection;
	String url="jdbc:mysql://localhost:3306/jdbcprc";
	String username="root";
	String password="root";
	public String savePerson(int id,String name,String address,long phone,int pin) {
		String query="insert into person values (?,?,?,?,?)";
		try {
			Class.forName(path);
			connection=DriverManager.getConnection(url,username,password);
			PreparedStatement preparedstatement=connection.prepareStatement(query);
			preparedstatement.setInt(1, id);
			preparedstatement.setString(2, name);
			preparedstatement.setString(3, address);
			preparedstatement.setLong(4, phone);
			preparedstatement.setInt(5, pin);
			
			int rows=preparedstatement.executeUpdate();
			if(rows==1) {
				return "saved";
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(connection !=null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return "unsaved";
	}

	public String updatePerson(int id,String name,String address,long phone,int pin) {
		String query="update person set name=?,address=?,phone=?,pin=? where id=? ";
		try {
			
			Class.forName(path);
			connection=DriverManager.getConnection(url, username, password);
			PreparedStatement preparedstatement=connection.prepareStatement(query);
		
			
			preparedstatement.setString(1, name);
			preparedstatement.setString(2,address );
			preparedstatement.setLong(3, phone);
			preparedstatement.setInt(4, pin);
			preparedstatement.setInt(5, id);
			
		   preparedstatement.execute();
			
				return "updated";
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(connection !=null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		return "not updated";
	}
	public String deletePerson(int id)
	{
		String query="delete from person  where id=?";
		try 
		{
			
			Class.forName(path);
			connection=DriverManager.getConnection(url, username, password);
			PreparedStatement preparedstatement=connection.prepareStatement(query);
		
			preparedstatement.setInt(1, id);

			
		   preparedstatement.executeUpdate();
			
				return "deleted";
			
			
		}
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		finally 
		{
			if(connection !=null)
			{
				try 
				{
					connection.close();
				} catch (SQLException e)
				{
					e.printStackTrace();
				}
			}
		}
		
		return "not deleted";
	}
	public String getPerson(int id)
	{
		String query="select * from person where id=?";
		try 
		{
			
			Class.forName(path);
			connection=DriverManager.getConnection(url, username, password);
			PreparedStatement preparedstatement=connection.prepareStatement(query);
		
			preparedstatement.setInt(1, id);
			
		  ResultSet resultset= preparedstatement.executeQuery();
		  while(resultset.next())
		  {
				System.out.println(resultset.getInt(1));
				System.out.println(resultset.getString(2));
				System.out.println(resultset.getString(3));
				System.out.println(resultset.getLong(4));
				System.out.println(resultset.getInt(5));
				
				System.out.println("****************");
				
				return "selected";
		  }
			
		} 
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally
		{
			if(connection !=null)
			{
				try 
				{
					connection.close();
				} 
				catch (SQLException e)
				{
					e.printStackTrace();
				}
	
			}
		}
		return "not selected";		
	}
	
	public  String savePersonObj(Person p) {
		String query="insert into person values (?,?,?,?,?)";
		try {
			Class.forName(path);
			connection=DriverManager.getConnection(url,username,password);
			PreparedStatement preparedstatement=connection.prepareStatement(query);
			preparedstatement.setInt(1, p.getId());
			preparedstatement.setString(2, p.getName());
			preparedstatement.setString(3, p.getAddress());
			preparedstatement.setLong(4, p.getPhone());
			preparedstatement.setInt(5, p.getPin());
			
			int rows=preparedstatement.executeUpdate();
			if(rows==1) {
				return "saved";
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(connection !=null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return "unsaved";
	}
	public String updatePersonObj(Person p) {
		String query="update person set name=?,address=?,phone=?,pin=? where id=? ";
		try {
			
			Class.forName(path);
			connection=DriverManager.getConnection(url, username, password);
			PreparedStatement preparedstatement=connection.prepareStatement(query);
		
			
			preparedstatement.setString(1, p.getName());
			preparedstatement.setString(2, p.getAddress() );
			preparedstatement.setLong(3, p.getPhone());
			preparedstatement.setInt(4, p.getPin());
			preparedstatement.setInt(5, p.getId());
			
		   preparedstatement.execute();
			
				return "updated";
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(connection !=null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		return "not updated";
	}
	public Person getPersonObj(int id)
	{
		String query="select * from person where id=?";
		try 
		{
			
			Class.forName(path);
			connection=DriverManager.getConnection(url, username, password);
			PreparedStatement preparedstatement=connection.prepareStatement(query);
		
			preparedstatement.setInt(1, id);
			
		  ResultSet resultset= preparedstatement.executeQuery();
		  if(resultset !=null) {
			 Person p=new Person();
		  while(resultset.next())
		  {
				p.setId(resultset.getInt(1));
				p.setName(resultset.getString(2));
				p.setAddress(resultset.getString(3));
				p.setPhone(resultset.getLong(4));
				p.setPin(resultset.getInt(5));
				
				System.out.println("****************");
				
				return p;
		  }
		  }
		} 
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally
		{
			if(connection !=null)
			{
				try 
				{
					connection.close();
				} 
				catch (SQLException e)
				{
					e.printStackTrace();
				}
	
			}
		}
	}

}
