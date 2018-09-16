package com.taxapp.taskexecutor;

import java.math.BigDecimal;
import java.util.concurrent.Callable;

import com.taxapp.service.TaxCalculator;

public class TaxTask implements Callable<BigDecimal> {

	private TaxCalculator taxCalculator;
	private String productName;
	private BigDecimal price;

	public TaxTask(TaxCalculator taxCalculator, String productName,
			BigDecimal price) {
		this.taxCalculator = taxCalculator;
		this.productName = productName;
		this.price = price;
	}

	@Override
	public BigDecimal call() throws Exception {
		return taxCalculator.calculateTax(productName, price);
	}

}
