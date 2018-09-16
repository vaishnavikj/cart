package com.taxapp.service;

import java.math.BigDecimal;

import com.taxapp.dao.InMemoryDataStore;
import com.taxapp.domain.TaxCategory;

public class TaxCalculatorImpl implements TaxCalculator {

	private InMemoryDataStore inMemoryDataStore;

	public TaxCalculatorImpl() {
		inMemoryDataStore = new InMemoryDataStore();
	}

	@Override
	public BigDecimal calculateTax(String productName, BigDecimal price) {
		BigDecimal tax = BigDecimal.ZERO;
		TaxCategory taxCategory = inMemoryDataStore
				.getTaxCategoryByProductName(productName);
		if (!taxCategory.getPercentage().equals(BigDecimal.ZERO)) {
			tax = (price.multiply(taxCategory.getPercentage()))
					.divide(new BigDecimal(100));
		}
		return tax;
	}
}