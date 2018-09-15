/**
 * 
 */
package test.java;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import main.java.ShoppingClient;
import main.java.client.dto.Order;
import main.java.client.dto.OrderLineItem;
import main.java.client.dto.Receipt;

import org.junit.Before;
import org.junit.Test;

/**
 * @author vaishnavi
 * 
 */
public class ShoppingClientTest {

	ShoppingClient client;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		// TODO : need to mock
		client = new ShoppingClient();
	}

	@Test
	public void purchaseOrder() {
		Order newOrder = new Order();
		newOrder.addOrderLineItem(new OrderLineItem("Basic",
				new BigDecimal(10), new BigDecimal(2)));
		

		Receipt mockReceipt = client.purchaseOrder(newOrder);
		assertEquals("20", mockReceipt.getPurchasedOrder().getTotalAmount()
				.toString());

	}

}
