package com.ty.controller;

import java.util.Scanner;

import com.ty.dao.Cart_DAO;
import com.ty.dto.Cart;

public class CartUpdate {
	public static void main(String[] args) {
		Cart c = new Cart();
		Cart_DAO cd = new Cart_DAO();

		Scanner s = new Scanner(System.in);
		System.out.println("enter update id");
		int id = s.nextInt();
		System.out.println("enter update email id");
		String email = s.next();
		System.out.println("enter update password");
		String password = s.next();
		System.out.println("enter update username");
		String username = s.next();
		System.out.println("enter update address");
		String address = s.next();

		c.setId(id);
		c.setEmail(email);
		c.setPassword(password);
		c.setUsername(username);
		c.setAddress(address);

		cd.updateCart(c);
		System.out.println("updated");
	}
}
