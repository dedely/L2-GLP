package data.order;

import process.visitor.OrderVisitor;

public class CreateUnit extends Order {

	private String unitToCreate;

	public CreateUnit(String unitToCreate) {
		this.unitToCreate = unitToCreate;
	}

	public String getUnitToCreate() {
		return unitToCreate;
	}

	public void setUnitToCreate(String unitToCreate) {
		this.unitToCreate = unitToCreate;
	}

	@Override
	public <T> T accept(OrderVisitor<T> visitor) {
		return visitor.visit(this);
	}

}