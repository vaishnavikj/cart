package main.com.taxapp.dto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Order {

	private List<OrderLineItem> orderLineItemList;

	private BigDecimal totalPrice;

	private BigDecimal totalTax;

	private BigDecimal totalAmount;

	public Order() {
		this.orderLineItemList = new ArrayList<OrderLineItem>();
	}

	public List<OrderLineItem> getOrderLineItemList() {
		return orderLineItemList;
	}

	public void setOrderLineItemList(List<OrderLineItem> orderLineItemList) {
		this.orderLineItemList = orderLineItemList;
	}

	public void addOrderLineItem(OrderLineItem orderLineItem) {
		this.orderLineItemList.add(orderLineItem);
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

	public BigDecimal getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}

	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("Order - { OrderLineItem List - ");
		for (OrderLineItem orderLineItem : orderLineItemList) {
			stringBuilder.append(orderLineItem.toString());
		}
		stringBuilder.append("\n OrderTotalprice - ").append(totalPrice)
				.append(", OrderTotalTax - ").append(totalTax)
				.append(", OrderTotalAmount - ").append(totalAmount)
				.append("}");
		return stringBuilder.toString();
	}

}