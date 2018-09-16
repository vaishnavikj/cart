/**
 * 
 */
package test;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import main.com.taxapp.dao.InMemoryDataStore;
import main.com.taxapp.dto.Order;
import main.com.taxapp.dto.OrderLineItem;
import main.com.taxapp.service.TaxCalculator;
import main.com.taxapp.service.TaxCalculatorImpl;
import main.com.taxapp.service.TaxServiceImpl;

import org.junit.Before;
import org.junit.Test;

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
		InMemoryDataStore inMemoryDataStore = new InMemoryDataStore();
		TaxCalculator taxCalculator = new TaxCalculatorImpl(inMemoryDataStore);
		taxServiceImpl = new TaxServiceImpl(taxCalculator, inMemoryDataStore);
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
