package main.java.taxapp.domain;

import java.math.BigDecimal;

public class TaxCategory {

	String name;

	String code;

	BigDecimal percentage;

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

	public static class TaxCategoryBuilder {

		TaxCategory taxCategory;

		public TaxCategoryBuilder setCode(String code) {
			taxCategory.code = code;
			return this;
		}

		public TaxCategory build() {
			return taxCategory;
		}
	}
}