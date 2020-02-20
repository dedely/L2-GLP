package cli.data.order;

import cli.data.Coordinates;
import cli.data.unit.Unit;

public class CreateUnit implements ProdBuildingOrder{
	private Unit unitToCreate;
	private Coordinates position;
	private int timeUntilConstructed;
	public Unit getUnitToCreate() {
		return unitToCreate;
	}
	public void setUnitToCreate(Unit unitToCreate) {
		this.unitToCreate = unitToCreate;
	}
	public Coordinates getPosition() {
		return position;
	}
	public void setPosition(Coordinates position) {
		this.position = position;
	}
	public int getTimeUntilConstructed() {
		return timeUntilConstructed;
	}
	public void setTimeUntilConstructed(int timeUntilConstructed) {
		this.timeUntilConstructed = timeUntilConstructed;
	}
		
}
