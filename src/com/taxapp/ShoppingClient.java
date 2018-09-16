package com.taxapp;

import java.math.BigDecimal;

import com.taxapp.dto.Order;
import com.taxapp.dto.OrderLineItem;
import com.taxapp.service.TaxServiceImpl;

public class ShoppingClient {

	public static void main(String[] a) {
		Order newOrder = new Order();
		newOrder.addOrderLineItem(new OrderLineItem("GSTProduct",
				BigDecimal.TEN, new BigDecimal(2)));
		// newOrder.addOrderLineItem(new OrderLineItem("Basic", BigDecimal.TEN,
		// new BigDecimal(2)));

		TaxServiceImpl taxServiceImpl = new TaxServiceImpl();
		Order purchasedOrder = taxServiceImpl.purchaseOrder(newOrder);
		System.out.print(purchasedOrder);

	}
}
