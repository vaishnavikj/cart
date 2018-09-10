package src;

import java.math.BigDecimal;

import src.dto.Order;
import src.dto.OrderLineItem;
import src.factory.CartObjectFactory;

public class Cart {

	public static void main(String[] a) {
		Order newOrder = new Order();
		newOrder.addOrderLineItem(new OrderLineItem("Basic", new BigDecimal(2)));
		newOrder.addOrderLineItem(new OrderLineItem("Premium", new BigDecimal(
				10)));

		Order purchasedOrder = CartObjectFactory.getInstance().getOrderFacade()
				.purchaseOrder(newOrder);

		System.out.print(purchasedOrder.toString());
	}
}
