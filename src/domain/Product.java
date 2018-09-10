package src.domain;

import java.math.BigDecimal;

public class Product {

	String name;

	BigDecimal unitPrice;

	String taxCategory;

	private Product() {

	}

	public Product(String name, BigDecimal unitPrice) {
		this.name = name;
		this.unitPrice = unitPrice;
	}

	public String getName() {
		return name;
	}

	public BigDecimal getUnitPrice() {
		return unitPrice;
	}

	public String getTaxCategory() {
		return taxCategory;
	}

	public static class ProductBuilder {
		Product product;

		public ProductBuilder() {
			product = new Product();
		}

		public ProductBuilder setName(String name) {
			product.name = name;
			return this;
		}

		public ProductBuilder setUnitPrice(BigDecimal unitPrice) {
			product.unitPrice = unitPrice;
			return this;
		}

		public ProductBuilder setTaxCategory(String taxCategory) {
			product.taxCategory = taxCategory;
			return this;
		}

		public Product build() {
			return product;
		}
	}
}