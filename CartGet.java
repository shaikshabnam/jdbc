package com.ty.controller;

import java.util.Scanner;

import com.ty.dao.Cart_DAO;
import com.ty.dto.Cart;

public class CartGet {
	public static void main(String[] args) {
		Cart c = new Cart();
		Cart_DAO cd = new Cart_DAO();

		Scanner s = new Scanner(System.in);
		System.out.println("enter id");
		int id = s.nextInt();
		
		c.setId(id);
		
		cd.getCart(c);
		
		System.out.println(c.getId());
		System.out.println(c.getEmail());
		System.out.println(c.getPassword());
		System.out.println(c.getUsername());
		System.out.println(c.getAddress());
	}
}
