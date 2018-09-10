package src.service;

import java.math.BigDecimal;

import src.dao.InMemoryDataStore;
import src.domain.Product;
import src.domain.TaxCategory;
import src.dto.Order;
import src.dto.OrderLineItem;
import src.factory.CartObjectFactory;

public class OrderServiceImpl implements OrderService {

	private InMemoryDataStore inMemoryDataStore;

	public OrderServiceImpl() {
		this.inMemoryDataStore = CartObjectFactory.getInstance()
				.getInMemoryDataStore();
	}

	@Override
	public Order purchaseOrder(Order order) {
		BigDecimal orderTotalPrice = BigDecimal.ZERO;
		BigDecimal orderTotalTax = BigDecimal.ZERO;
		for (OrderLineItem orderLineItem : order.getOrderLineItemList()) {
			// Calculating totalPrice
			Product product = inMemoryDataStore.getProductMap().get(
					orderLineItem.getProductName());
			orderLineItem.setTotalPrice(orderLineItem.getQuantity().multiply(
					product.getUnitPrice()));
			orderLineItem.setUnitPrice(product.getUnitPrice());
			orderTotalPrice = orderTotalPrice
					.add(orderLineItem.getTotalPrice());
			// Calculating totalTax
			if (null != product.getTaxCategory()) {
				calculateTotalTax(orderTotalTax, orderLineItem,
						product.getTaxCategory());
			}
		}
		order.setTotalPrice(orderTotalPrice);
		order.setTotalTax(orderTotalTax);
		order.setTotalAmount(orderTotalPrice.add(orderTotalTax));
		return order;
	}

	/**
	 * 
	 * @param orderTotalTax
	 * @param orderLineItem
	 * @param productTaxCategory
	 * @return
	 */
	private BigDecimal calculateTotalTax(BigDecimal orderTotalTax,
			OrderLineItem orderLineItem, String productTaxCategory) {
		TaxCategory taxCategory = inMemoryDataStore.getTaxCategoryMap().get(
				productTaxCategory);
		if (!taxCategory.getPercentage().equals(BigDecimal.ZERO)) {
			orderLineItem.setTotalTax((orderLineItem.getTotalPrice()
					.multiply(taxCategory.getPercentage()))
					.divide(new BigDecimal(100)));
		}
		orderTotalTax = orderTotalTax.add(orderLineItem.getTotalTax());
		return orderTotalTax;
	}
}
