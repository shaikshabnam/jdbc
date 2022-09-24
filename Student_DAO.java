package com.ty.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ty.dto.Student;

public class Student_DAO {
	String path = "com.mysql.cj.jdbc.Driver";
	Connection connection = null;
	String url = "jdbc:mysql://localhost:3306/jdbcprc";
	String username = "root";
	String password = "root";

	public Student saveStudent(Student s) {
		String query = "insert into student values(?,?,?,?,?)";
		try {
			Class.forName(path);
			connection = DriverManager.getConnection(url, username, password);
			PreparedStatement preparedStatement = connection.prepareStatement(query);

			preparedStatement.setInt(1, s.getId());
			preparedStatement.setString(2, s.getName());
			preparedStatement.setLong(3, s.getPhno());
			preparedStatement.setString(4, s.getAddress());
			preparedStatement.setInt(5, s.getPincode());

			preparedStatement.execute();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return s;
	}

	public Student updateStudent(Student s) {
		String query = "update student set name=?,phno=?,address=?,pincode=? where id=?";
		try {
			Class.forName(path);
			connection = DriverManager.getConnection(url, username, password);
			PreparedStatement preparedStatement = connection.prepareStatement(query);

			preparedStatement.setString(1, s.getName());
			preparedStatement.setLong(2, s.getPhno());
			preparedStatement.setString(3, s.getAddress());
			preparedStatement.setInt(4, s.getPincode());
			preparedStatement.setInt(5, s.getId());

			preparedStatement.execute();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return s;
	}

	public String deleteStudent(int id) {
		String query = "delete from student where id=?";
		try {
			Class.forName(path);
			connection = DriverManager.getConnection(url, username, password);
			PreparedStatement preparedStatement = connection.prepareStatement(query);

			preparedStatement.setInt(1, id);

			preparedStatement.execute();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return "deleted";
	}

	public Student getStudent(Student s) {
		String query = "select * from student where id=?";
		try {
			Class.forName(path);
			connection = DriverManager.getConnection(url, username, password);
			PreparedStatement preparedStatement = connection.prepareStatement(query);

			preparedStatement.setInt(1, s.getId());
			ResultSet resultset = preparedStatement.executeQuery();
			while (resultset.next()) {
				s.setId(resultset.getInt(1));
				s.setName(resultset.getString(2));
				s.setPhno(resultset.getLong(3));
				s.setAddress(resultset.getString(4));
				s.setPincode(resultset.getInt(5));

			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return s;
	}

	public List<Student> getAllStudent() {
		String query = "select * from student";
		try {
			Class.forName(path);
			connection = DriverManager.getConnection(url, username, password);
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			ResultSet resultSet = preparedStatement.executeQuery();
			Student s = new Student();
			List<Student> list = new ArrayList();
			while (resultSet.next()) {
				s.setId(resultSet.getInt(1));
				s.setName(resultSet.getString(2));
				s.setPhno(resultSet.getLong(3));
				s.setAddress(resultSet.getString(4));
				s.setPincode(resultSet.getInt(5));

				list.add(s);
			}
			return list;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if (connection != null) {
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
