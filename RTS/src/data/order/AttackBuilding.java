package data.order;

import data.Coordinates;
import data.Selectable;

public class AttackBuilding implements DefBuildingOrder {

	private Coordinates position;
	private Selectable target;
	
	public Coordinates getPosition() {
		return position;
	}
	public void setPosition(Coordinates position) {
		this.position = position;
	}
	public Selectable getTarget() {
		return target;
	}
	public void setTarget(Selectable target) {
		this.target = target;
	}
	
	
}
