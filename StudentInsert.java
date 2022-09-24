package com.ty.controller;

import java.util.Scanner;

import com.ty.dao.Student_DAO;
import com.ty.dto.Student;

public class StudentInsert {
	public static void main(String[] args) {
		Student s = new Student();
		Student_DAO sd = new Student_DAO();
		Scanner sc = new Scanner(System.in);

		System.out.println("enter student id");
		int id = sc.nextInt();
		System.out.println("enter student name");
		String name = sc.next();
		System.out.println("enter student phone number");
		long phno = sc.nextLong();
		System.out.println("enter student address");
		String address = sc.next();
		System.out.println("enter student pincode");
		int pincode = sc.nextInt();

		s.setId(id);
		s.setName(name);
		s.setPhno(phno);
		s.setAddress(address);
		s.setPincode(pincode);

		sd.saveStudent(s);
		System.out.println("saved");
	}
}
