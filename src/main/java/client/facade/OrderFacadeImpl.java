package main.java.client.facade;

import main.java.client.dto.Order;
import main.java.client.service.OrderService;

public class OrderFacadeImpl implements OrderFacade {

	private OrderService orderService;

	public OrderFacadeImpl(OrderService orderService) {
		this.orderService = orderService;
	}

	@Override
	public Order purchaseOrder(Order order) {
		return orderService.purchaseOrder(order);
	}

}
