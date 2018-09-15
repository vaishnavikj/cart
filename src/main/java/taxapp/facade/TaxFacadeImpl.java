package main.java.taxapp.facade;

import main.java.taxapp.domain.TaxCategory;
import main.java.taxapp.service.TaxService;

public class TaxFacadeImpl implements TaxFacade {

	private TaxService taxService;

	public TaxFacadeImpl(TaxService taxService) {
		this.taxService = taxService;
	}

	@Override
	public TaxCategory getTaxCategoryByProductName(String productName) {
		return taxService.getTaxCategoryByProductName(productName);
	}

}
