package main.java.client.dao;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import main.java.client.domain.Product;
import main.java.taxapp.domain.TaxCategory;

public class InMemoryDataStore {

	private Map<String, Product> productMap;

	private Map<String, TaxCategory> taxCategoryMap;

	public InMemoryDataStore() {
		productMap = new HashMap<>();
		// Preparing ProductMap
		productMap.put("Basic", new Product("Basic"));
		productMap.put("Standard", new Product("Standard"));
		Product.ProductBuilder taxationProduct = new Product.ProductBuilder();
		taxationProduct.build();
		taxationProduct.setName("Premium");
		taxationProduct.setTaxCategory("ZERO_TAX");
		productMap.put("Premium", taxationProduct.build());

		// Preparing taxCategoryMap
		taxCategoryMap = new HashMap<>();
		taxCategoryMap.put("SGST", new TaxCategory("SGST", new BigDecimal(5)));
		taxCategoryMap.put("CGST", new TaxCategory("CGST", new BigDecimal(5)));
		taxCategoryMap.put("ZERO_TAX", new TaxCategory("ZERO_TAX",
				new BigDecimal(0)));
	}

	public TaxCategory getTaxCategoryByProductName(String productName) {
		Product product = getProductByProductName(productName);
		return taxCategoryMap.get(product.getTaxCategory());
	}

	public Product getProductByProductName(String productName) {
		return productMap.get(productName);
	}

}