package main.java.client.service;

import main.java.client.dto.Order;

public interface OrderService {

	/**
	 * 
	 * @param order
	 * @return
	 */
	Order purchaseOrder(Order order);
}
