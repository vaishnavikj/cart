/**
 * 
 */
package test.com.taxapp.service;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

import com.taxapp.dto.Order;
import com.taxapp.dto.OrderLineItem;
import com.taxapp.service.TaxServiceImpl;

/**
 * @author vaishnavi
 * 
 */
public class TaxServiceImplTest {

	TaxServiceImpl taxServiceImpl;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		taxServiceImpl = new TaxServiceImpl();
	}

	@Test
	public void purchaseOrder() {
		Order newOrder = new Order();
		newOrder.addOrderLineItem(new OrderLineItem("Basic",
				new BigDecimal(10), new BigDecimal(2)));

		Order actualOrder = taxServiceImpl.purchaseOrder(newOrder);
		assertEquals("20", actualOrder.getTotalAmount().toString());
	}
}
