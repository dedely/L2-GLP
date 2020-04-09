package data.order;

import process.visitor.OrderVisitor;
import process.visitor.SelectableVisitor;

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