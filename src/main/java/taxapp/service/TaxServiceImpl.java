package main.java.taxapp.service;

import main.java.client.dao.InMemoryDataStore;
import main.java.taxapp.domain.TaxCategory;

class TaxServiceImpl implements TaxService {

	InMemoryDataStore inMemoryDataStore;

	public TaxServiceImpl(InMemoryDataStore inMemoryDataStore) {
		this.inMemoryDataStore = inMemoryDataStore;
	}

	@Override
	public TaxCategory getTaxCategoryByProductName(String productName) {
		return inMemoryDataStore.getTaxCategoryByProductName(productName);
	}

}
