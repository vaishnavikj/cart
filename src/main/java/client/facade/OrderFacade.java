package main.java.client.facade;

import main.java.client.dto.Order;

public interface OrderFacade {

	/**
	 * 
	 * @param order
	 * @return
	 */
	Order purchaseOrder(Order order);

}
