package src.factory.taxation;

import src.domain.TaxCategory;

public class MedicalTaxFactory extends AbstractTaxFactory {

	public MedicalTaxFactory() {
//		taxCategory = new MedicalTaxCategory();
	}

	@Override
	public TaxCategory getTaxCategory() {
		return taxCategory;
	}
	
	
}
