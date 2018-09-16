package com.taxapp.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import com.taxapp.dto.Order;
import com.taxapp.dto.OrderLineItem;
import com.taxapp.taskexecutor.TaxTask;

public class TaxServiceImpl {

	private TaxCalculator taxCalculator;

	public TaxServiceImpl() {
		this.taxCalculator = new TaxCalculatorImpl();
	}

	public TaxServiceImpl(TaxCalculator taxCalculator) {
		this.taxCalculator = taxCalculator;
	}

	public Order purchaseOrder(Order order) {
		BigDecimal orderTotalPrice = BigDecimal.ZERO;
		for (OrderLineItem orderLineItem : order.getOrderLineItemList()) {
			orderLineItem.setTotalPrice(orderLineItem.getQuantity().multiply(
					orderLineItem.getUnitPrice()));
			orderTotalPrice = orderTotalPrice
					.add(orderLineItem.getTotalPrice());
		}
		// Calculating tax
		calculateTax(order);
		order.setTotalPrice(orderTotalPrice);

		order.setTotalAmount(orderTotalPrice.add(order.getTotalTax()));
		return order;
	}

	/**
	 * 
	 * @param order
	 * @return
	 */
	private void calculateTax(Order order) {
		BigDecimal orderTotalTax = BigDecimal.ZERO;
		for (OrderLineItem orderLineItem : order.getOrderLineItemList()) {
			orderLineItem.setTotalTax(taxCalculator.calculateTax(
					orderLineItem.getProductName(),
					orderLineItem.getTotalPrice()));
			orderTotalTax = orderTotalTax.add(orderLineItem.getTotalTax());
		}
	}

	/**
	 * 
	 * @param order
	 * @return
	 */
	private void calculateTaxMultiThread(Order order) {
		BigDecimal orderTotalTax = BigDecimal.ZERO;
		ExecutorService executor = Executors.newFixedThreadPool(10);
		List<Future<BigDecimal>> list = new ArrayList<Future<BigDecimal>>();

		for (OrderLineItem orderLineItem : order.getOrderLineItemList()) {
			list.add(executor.submit(new TaxTask(taxCalculator, orderLineItem
					.getProductName(), orderLineItem.getTotalPrice())));

		}

		for (Future<BigDecimal> f : list) {
			try {
				if (f.isDone()) {
					orderTotalTax = orderTotalTax.add(f.get());
				}
			} catch (InterruptedException | ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		order.setTotalTax(orderTotalTax);
	}
}