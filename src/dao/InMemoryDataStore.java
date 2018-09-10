package src.dao;

import java.util.Map;

import src.domain.Product;
import src.domain.TaxCategory;

public class InMemoryDataStore {

	private Map<String, Product> productMap;

	private Map<String, TaxCategory> taxCategoryMap;

	public Map<String, Product> getProductMap() {
		return productMap;
	}

	public void setProductMap(Map<String, Product> productMap) {
		this.productMap = productMap;
	}

	public Map<String, TaxCategory> getTaxCategoryMap() {
		return taxCategoryMap;
	}

	public void setTaxCategoryMap(Map<String, TaxCategory> taxCategoryMap) {
		this.taxCategoryMap = taxCategoryMap;
	}

}
