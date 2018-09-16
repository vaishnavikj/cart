package main.com.taxapp.service;

import java.math.BigDecimal;

import main.com.taxapp.dao.InMemoryDataStore;
import main.com.taxapp.domain.TaxCategory;

public class TaxCalculatorImpl implements TaxCalculator {

	InMemoryDataStore inMemoryDataStore;

	public TaxCalculatorImpl(InMemoryDataStore inMemoryDataStore) {
		this.inMemoryDataStore = inMemoryDataStore;
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