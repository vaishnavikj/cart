package main.java;

import java.math.BigDecimal;

import main.java.client.dao.InMemoryDataStore;
import main.java.client.dto.Order;
import main.java.client.dto.OrderLineItem;
import main.java.client.dto.Receipt;
import main.java.client.facade.OrderFacade;
import main.java.client.facade.OrderFacadeImpl;
import main.java.client.service.OrderService;
import main.java.client.service.OrderServiceImpl;
import main.java.taxapp.facade.TaxFacade;
import main.java.taxapp.facade.TaxFacadeImpl;
import main.java.taxapp.service.TaxService;
import main.java.taxapp.service.TaxServiceImpl;

public class ShoppingClient {

	// TODO : Inject
	InMemoryDataStore inMemoryDataStore = new InMemoryDataStore();
	TaxFacade taxFacade = getTaxFacadeImpl();
	OrderFacade orderFacade = getOrderFacadeImpl();

	public static void main(String[] a) {
		Order newOrder = new Order();
		newOrder.addOrderLineItem(new OrderLineItem("Basic",
				new BigDecimal(10), new BigDecimal(2)));
//		newOrder.addOrderLineItem(new OrderLineItem("Premium", new BigDecimal(
//				10), new BigDecimal(10)));

		ShoppingClient client = new ShoppingClient();
		Receipt receipt = client.purchaseOrder(newOrder);
		System.out.print(receipt);

	}

	private OrderFacade getOrderFacadeImpl() {
		if (null == orderFacade) {
			OrderService orderService = new OrderServiceImpl(inMemoryDataStore,
					taxFacade);
			orderFacade = new OrderFacadeImpl(orderService);
		}
		return orderFacade;
	}

	private TaxFacade getTaxFacadeImpl() {
		if (null == taxFacade) {
			TaxService taxService = new TaxServiceImpl(inMemoryDataStore);
			taxFacade = new TaxFacadeImpl(taxService);
		}
		return taxFacade;
	}

	/**
	 * 
	 * @param newOrder
	 */
	public Receipt purchaseOrder(Order newOrder) {
		Receipt receipt = new Receipt();
		receipt.setPurchasedOrder(orderFacade.purchaseOrder(newOrder));
		return receipt;
	}
}
