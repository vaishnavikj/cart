package main.java.taxapp.service;

import main.java.taxapp.domain.TaxCategory;

public interface TaxService {

	/**
	 * 
	 * @param productName
	 * @return
	 */
	TaxCategory getTaxCategoryByProductName(String productName);
}
