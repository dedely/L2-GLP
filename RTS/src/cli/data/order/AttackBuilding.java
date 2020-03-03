package cli.data.order;

import cli.data.Constants;
import data.Coordinates;
import data.Selectable;

public class AttackBuilding extends Order {

	private Coordinates position;
	private Selectable target;
	
	
	
	public AttackBuilding(Coordinates position, Selectable target) {
		setType(Constants.ATTACK_BUILDING);
		this.position = position;
		this.target = target;
	}
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
