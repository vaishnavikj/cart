package main.com.taxapp.service;

import java.math.BigDecimal;

import main.com.taxapp.dao.InMemoryDataStore;
import main.com.taxapp.domain.Product;
import main.com.taxapp.dto.Order;
import main.com.taxapp.dto.OrderLineItem;
import main.com.taxapp.exception.TaxAppRunTimeException;

public class TaxServiceImpl {

	TaxCalculator taxCalculator;
	InMemoryDataStore inMemoryDataStore;

	public TaxServiceImpl(TaxCalculator taxCalculator,
			InMemoryDataStore inMemoryDataStore) {
		this.taxCalculator = taxCalculator;
		this.inMemoryDataStore = inMemoryDataStore;
	}

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
			if (null == product.getTaxCategory()) {
				throw new TaxAppRunTimeException(
						"TaxCategory is missing for the product - "
								+ product.getName());
			} else {
				orderTotalTax = orderTotalTax.add(calculateTax(orderLineItem));
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
	 * @return
	 */
	private BigDecimal calculateTax(OrderLineItem orderLineItem) {
		return taxCalculator.calculateTax(orderLineItem.getProductName(),
				orderLineItem.getTotalPrice());
	}
}