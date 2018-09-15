package main.java.client.service;

import java.math.BigDecimal;

import main.java.client.dao.InMemoryDataStore;
import main.java.client.domain.Product;
import main.java.client.dto.Order;
import main.java.client.dto.OrderLineItem;
import main.java.taxapp.domain.TaxCategory;
import main.java.taxapp.facade.TaxFacade;

public class OrderServiceImpl implements OrderService {

	private InMemoryDataStore inMemoryDataStore;

	private TaxFacade taxFacade;
	
	public OrderServiceImpl(InMemoryDataStore productInMemoryDataStore, TaxFacade taxFacade) {
		this.inMemoryDataStore = productInMemoryDataStore;
		this.taxFacade = taxFacade;
	}

	@Override
	public Order purchaseOrder(Order order) {
		BigDecimal orderTotalPrice = BigDecimal.ZERO;
		BigDecimal orderTotalTax = BigDecimal.ZERO;
		for (OrderLineItem orderLineItem : order.getOrderLineItemList()) {
			// Calculating totalPrice
			Product product = inMemoryDataStore
					.getProductByProductName(orderLineItem.getProductName());
			orderLineItem.setTotalPrice(orderLineItem.getQuantity().multiply(
					orderLineItem.getUnitPrice()));
			orderTotalPrice = orderTotalPrice
					.add(orderLineItem.getTotalPrice());
			// Calculating tax
			if (null != product.getTaxCategory()) {
				orderTotalTax = orderTotalTax.add(calculateTax(orderLineItem,
						orderLineItem.getProductName()));
			}
		}
		order.setTotalPrice(orderTotalPrice);
		order.setTotalTax(orderTotalTax);
		order.setTotalAmount(orderTotalPrice.add(orderTotalTax));
		return order;
	}

	/**
	 * 
	 * @param orderLineItem
	 * @param productName
	 * @return
	 */
	private BigDecimal calculateTax(OrderLineItem orderLineItem,
			String productName) {
		TaxCategory taxCategory = taxFacade
				.getTaxCategoryByProductName(productName);
		if (!taxCategory.getPercentage().equals(BigDecimal.ZERO)) {
			orderLineItem.setTotalTax((orderLineItem.getTotalPrice()
					.multiply(taxCategory.getPercentage()))
					.divide(new BigDecimal(100)));
		}
		return orderLineItem.getTotalTax();
	}
}
