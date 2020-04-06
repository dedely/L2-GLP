package data.order;

import data.Constants;
import data.Coordinates;


public class CreateUnit extends Order{
	
	private String unitToCreate;
	
	private Coordinates position;

	private int timeUntilConstructed;

	public CreateUnit(String unitToCreate, Coordinates position, int timeUntilConstructed) {

		setType(Constants.CREATE_UNIT);

		this.position=position;
		this.timeUntilConstructed=timeUntilConstructed;
		this.unitToCreate=unitToCreate;
	}


	public String getUnitToCreate() {
		return unitToCreate;
	}

	public void setUnitToCreate(String unitToCreate) {
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