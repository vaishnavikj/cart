package com.taxapp.domain;

public class Product {

	private String name;

	private String taxCategory;

	public Product(String name, String taxCategory) {
		this.name = name;
		this.taxCategory = taxCategory;
	}

	public String getName() {
		return name;
	}

	public String getTaxCategory() {
		return taxCategory;
	}

}