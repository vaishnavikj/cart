package src.factory;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import src.dao.InMemoryDataStore;
import src.domain.Product;
import src.domain.TaxCategory;
import src.facade.OrderFacade;
import src.facade.OrderFacadeImpl;
import src.service.OrderServiceImpl;

public final class CartObjectFactory {

	private static CartObjectFactory cartObjectFactory;
	private OrderFacade orderFacade;
	private InMemoryDataStore inMemoryDataStore;

	private CartObjectFactory() {
	}

	public static CartObjectFactory getInstance() {
		if (cartObjectFactory == null) {
			cartObjectFactory = new CartObjectFactory();
		}
		return cartObjectFactory;
	}

	public InMemoryDataStore getInMemoryDataStore() {
		if (null == inMemoryDataStore) {
			initializeInMemoryDataStore();
		}
		return inMemoryDataStore;
	}

	public OrderFacade getOrderFacade() {
		// TODO : will inject later
		if (orderFacade == null) {
			orderFacade = new OrderFacadeImpl(new OrderServiceImpl());
		}
		return orderFacade;
	}

	private void initializeInMemoryDataStore() {
		inMemoryDataStore = new InMemoryDataStore();
		// Preparing ProductMap
		Map<String, Product> productMap = new HashMap<String, Product>();
		productMap.put("Basic", new Product("Basic", new BigDecimal(20)));
		productMap.put("Standard", new Product("Standard", new BigDecimal(50)));

		Product.ProductBuilder taxationProduct = new Product.ProductBuilder();
		taxationProduct.build();
		taxationProduct.setName("Premium");
		taxationProduct.setUnitPrice(new BigDecimal(100));
		taxationProduct.setTaxCategory("ZERO_TAX");
		productMap.put("Premium", taxationProduct.build());
		inMemoryDataStore.setProductMap(productMap);

		// Preparing taxCategoryMap
		Map<String, TaxCategory> taxCategoryMap = new HashMap<String, TaxCategory>();
		taxCategoryMap.put("SGST", new TaxCategory("SGST", new BigDecimal(5)));
		taxCategoryMap.put("CGST", new TaxCategory("CGST", new BigDecimal(5)));
		taxCategoryMap.put("ZERO_TAX", new TaxCategory("ZERO_TAX",
				new BigDecimal(0)));
		inMemoryDataStore.setTaxCategoryMap(taxCategoryMap);
	}
}