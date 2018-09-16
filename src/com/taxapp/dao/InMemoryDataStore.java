package com.taxapp.dao;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import com.taxapp.domain.Product;
import com.taxapp.domain.TaxCategory;

public class InMemoryDataStore {

	private Map<String, Product> productMap;

	private Map<String, TaxCategory> taxCategoryMap;

	public InMemoryDataStore() {
		// Preparing taxCategoryMap
		taxCategoryMap = new HashMap<>();
		taxCategoryMap.put("SGST", new TaxCategory("SGST", new BigDecimal(5)));
		taxCategoryMap.put("CGST", new TaxCategory("CGST", new BigDecimal(5)));
		taxCategoryMap.put("ZERO_TAX", new TaxCategory("ZERO_TAX",
				new BigDecimal(0)));

		// Preparing ProductMap
		productMap = new HashMap<>();
		productMap.put("Basic", new Product("Basic", "ZERO_TAX"));
		productMap.put("Standard", new Product("Standard", "GST"));

	}

	public TaxCategory getTaxCategoryByProductName(String productName) {
		Product product = getProductByProductName(productName);
		return taxCategoryMap.get(product.getTaxCategory());
	}

	public Product getProductByProductName(String productName) {
		return productMap.get(productName);
	}

}