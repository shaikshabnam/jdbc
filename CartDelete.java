package com.ty.controller;

import java.util.Scanner;

import com.ty.dao.Cart_DAO;
import com.ty.dto.Cart;

public class CartDelete {

	public static void main(String[] args) {
		Cart c = new Cart();
		Cart_DAO cd = new Cart_DAO();

		Scanner s = new Scanner(System.in);
		System.out.println("enter  id which u want to delete");
		int id = s.nextInt();

		c.setId(id);
		cd.deleteCart(id);
		System.out.println("deleted");
	}
}
