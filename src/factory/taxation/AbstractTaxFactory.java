package src.factory.taxation;

import src.domain.TaxCategory;

public abstract class AbstractTaxFactory {

	public TaxCategory taxCategory;

	public abstract TaxCategory getTaxCategory();

}
