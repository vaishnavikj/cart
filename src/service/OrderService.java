package src.service;

import src.dto.Order;

public interface OrderService {

	/**
	 * 
	 * @param order
	 * @return
	 */
	Order purchaseOrder(Order order);
}
