package src.dto;

import java.math.BigDecimal;

public class OrderLineItem {

	private String productName;

	private BigDecimal unitPrice;

	private BigDecimal quantity;

	private BigDecimal totalPrice;

	private BigDecimal totalTax = BigDecimal.ZERO;

	public OrderLineItem(String productName, BigDecimal quantity) {
		this.productName = productName;
		this.quantity = quantity;
	}

	public String getProductName() {
		return productName;
	}

	public BigDecimal getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}

	public BigDecimal getQuantity() {
		return quantity;
	}

	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}

	public BigDecimal getTotalTax() {
		return totalTax;
	}

	public void setTotalTax(BigDecimal totalTax) {
		this.totalTax = totalTax;
	}

	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("\n[ ProductName - ").append(productName)
				.append(", Quantity - ").append(quantity)
				.append(", UnitPrice - ").append(unitPrice)
				.append(", TotalPrice - ").append(totalPrice)
				.append(", TotalTax - ").append(totalTax).append("]");
		return stringBuilder.toString();
	}
}
