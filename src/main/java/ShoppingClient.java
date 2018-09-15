package main.java;

import java.math.BigDecimal;

import main.java.client.dto.Order;
import main.java.client.dto.OrderLineItem;
import main.java.client.facade.OrderFacade;
import main.java.client.facade.OrderFacadeImpl;

public class ShoppingClient {

	public static void main(String[] a) {
		Order newOrder = new Order();
		newOrder.addOrderLineItem(new OrderLineItem("Basic",
				new BigDecimal(10), new BigDecimal(2)));
		newOrder.addOrderLineItem(new OrderLineItem("Premium", new BigDecimal(
				10), new BigDecimal(10)));

		OrderFacade orderFacade = new OrderFacadeImpl(orderService);
		Order purchasedOrder = orderFacade.purchaseOrder(newOrder);

		System.out.print(purchasedOrder);
	}
}
