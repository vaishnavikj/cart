package src.facade;

import src.dto.Order;
import src.service.OrderService;

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
