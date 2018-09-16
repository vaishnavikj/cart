package com.taxapp.domain;

import java.math.BigDecimal;

public class TaxCategory {

	private String name;

	private BigDecimal percentage;

	public TaxCategory(String name, BigDecimal percentage) {
		this.name = name;
		this.percentage = percentage;
	}

	public String getName() {
		return name;
	}

	public BigDecimal getPercentage() {
		return percentage;
	}

}