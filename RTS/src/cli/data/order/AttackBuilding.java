package cli.data.order;

import cli.data.Coordinates;
import cli.data.Selectable;

public class AttackBuilding implements DefBuildingOrder {

	private Coordinates position;
	private int movingBehaviour;
	private Selectable target;
	
	public Coordinates getPosition() {
		return position;
	}
	public void setPosition(Coordinates position) {
		this.position = position;
	}
	public int getMovingBehaviour() {
		return movingBehaviour;
	}
	public void setMovingBehaviour(int movingBehaviour) {
		this.movingBehaviour = movingBehaviour;
	}
	public Selectable getTarget() {
		return target;
	}
	public void setTarget(Selectable target) {
		this.target = target;
	}
	
	
}
