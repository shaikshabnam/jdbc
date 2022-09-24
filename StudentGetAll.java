package com.ty.controller;

import java.util.ArrayList;
import java.util.List;

import com.ty.dao.Student_DAO;
import com.ty.dto.Student;

public class StudentGetAll {
	public static void main(String[] args) {
		Student s = new Student();
		Student_DAO sd = new Student_DAO();
		List<Student> list = sd.getAllStudent();
		for (Student value : list) {
			System.out.println(value);
		}
	}
}
