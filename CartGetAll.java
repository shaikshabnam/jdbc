package com.ty.controller;

import java.util.List;
import java.util.Scanner;

import com.ty.dao.Cart_DAO;
import com.ty.dto.Cart;

public class CartGetAll {

	public static void main(String[] args) {
		
	
	
	Cart c = new Cart();
	Cart_DAO cd = new Cart_DAO();
	
	List<Cart>list=cd.getAllCart();
	for(Cart value:list) {
		System.out.println(value);
	}
	}
}
