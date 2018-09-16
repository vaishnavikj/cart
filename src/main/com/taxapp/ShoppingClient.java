package main.com.taxapp;

import java.math.BigDecimal;

import main.com.taxapp.dao.InMemoryDataStore;
import main.com.taxapp.dto.Order;
import main.com.taxapp.dto.OrderLineItem;
import main.com.taxapp.service.TaxCalculator;
import main.com.taxapp.service.TaxCalculatorImpl;
import main.com.taxapp.service.TaxServiceImpl;

public class ShoppingClient {

	public static void main(String[] a) {
		Order newOrder = new Order();
		newOrder.addOrderLineItem(new OrderLineItem("GSTProduct", BigDecimal.TEN,
				new BigDecimal(2)));
		newOrder.addOrderLineItem(new OrderLineItem("Basic", BigDecimal.TEN,
				new BigDecimal(2)));

		InMemoryDataStore inMemoryDataStore = new InMemoryDataStore();
		TaxCalculator taxCalculator = new TaxCalculatorImpl(inMemoryDataStore);
		TaxServiceImpl taxServiceImpl = new TaxServiceImpl(taxCalculator,
				inMemoryDataStore);
		Order purchasedOrder = taxServiceImpl.purchaseOrder(newOrder);
		System.out.print(purchasedOrder);

	}
}
