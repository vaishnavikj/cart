package main.java.taxapp.facade;

import main.java.taxapp.domain.TaxCategory;

public interface TaxFacade {

	/**
	 * 
	 * @param productName
	 * @return
	 */
	TaxCategory getTaxCategoryByProductName(String productName);

}
