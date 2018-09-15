package main.java.client.dao;

import java.util.HashMap;
import java.util.Map;

import main.java.client.domain.Product;
import main.java.taxapp.domain.TaxCategory;

public class InMemoryDataStore {

	private Map<String, Product> productMap;

	private Map<String, TaxCategory> taxCategoryMap;

	public InMemoryDataStore() {
		productMap = new HashMap<>();
		taxCategoryMap = new HashMap<>();
	}
	
	public TaxCategory getTaxCategoryByProductName(String productName) {
		Product product = getProductByProductName(productName);
		return taxCategoryMap.get(product.getTaxCategory());
	}
	
	public Product getProductByProductName(String productName) {
		return productMap.get(productName);
	}

}