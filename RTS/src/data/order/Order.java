package data.order;

import process.visitor.order.OrderVisitor;

public abstract class Order {
	private String type;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public abstract <T> T accept(OrderVisitor<T> visitor);
}