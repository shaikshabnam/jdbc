package com.ty.controller;

import java.util.Scanner;

import com.ty.dao.Student_DAO;
import com.ty.dto.Student;

public class Studentdelete {
	public static void main(String[] args) {
		Student s = new Student();
		Student_DAO sd = new Student_DAO();
		Scanner sc=new Scanner(System.in);
		
		System.out.println("enter student id");
		int id=sc.nextInt();
		
		s.setId(id);
		sd.deleteStudent(id);
		
		System.out.println("deleted");
	}
}
