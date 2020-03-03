package data.order;

import data.Coordinates;
import data.unit.Unit;

public class CreateUnit implements ProdBuildingOrder{
	
	private Unit unitToCreate;
	
	private Coordinates position;
	
	private int timeUntilConstructed;
	
	public CreateUnit (Unit unitToCreate, Coordinates position, int timeUntilConstructed) {
		this.position=position;
		this.timeUntilConstructed=timeUntilConstructed;
		this.unitToCreate=unitToCreate;
	}
	
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