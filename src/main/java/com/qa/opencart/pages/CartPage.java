package com.qa.opencart.pages;

import org.openqa.selenium.By;

public class CartPage {

	By cart=By.id("cart");
	
	
	public boolean addcart() {
		System.out.println("Add things");
		return true;
	}
	
	public static void main(String[] args) {
	System.out.println("add to cart");
	}

}
