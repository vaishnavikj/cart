package main.com.taxapp.domain;

public class Product {

	String name;

	String code;

	String taxCategory;

	private Product() {

	}

	public Product(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
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

		public ProductBuilder setCode(String productCode) {
			product.code = productCode;
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