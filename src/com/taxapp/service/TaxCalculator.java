package com.taxapp.service;

import java.math.BigDecimal;

public interface TaxCalculator {

	/**
	 * 
	 * @param productName
	 * @param price
	 * @return
	 */
	BigDecimal calculateTax(String productName, BigDecimal price);
}