package com.ty.controller;

import java.util.Scanner;

import com.ty.dao.Cart_DAO;
import com.ty.dto.Cart;

public class CartInsert {
	public static void main(String[] args) {
		Cart c = new Cart();
		Cart_DAO cd = new Cart_DAO();

		Scanner s = new Scanner(System.in);
		System.out.println("enter id");
		int id = s.nextInt();
		System.out.println("enter email id");
		String email = s.next();
		System.out.println("enter password");
		String password = s.next();
		System.out.println("enter username");
		String username = s.next();
		System.out.println("enter address");
		String address = s.next();

		c.setId(id);
		c.setEmail(email);
		c.setPassword(password);
		c.setUsername(username);
		c.setAddress(address);

		cd.saveCart(c);
		System.out.println("saved");
	}
}
