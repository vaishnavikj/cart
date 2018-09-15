package main.java.client.dto;

public class Receipt {

	private Order purchasedOrder;

	public Order getPurchasedOrder() {
		return purchasedOrder;
	}

	public void setPurchasedOrder(Order purchasedOrder) {
		this.purchasedOrder = purchasedOrder;
	}

	@Override
	public String toString() {
		return purchasedOrder.toString();
	}
}