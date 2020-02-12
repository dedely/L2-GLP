package cli.data.order;

import cli.data.Coordinates;
import cli.data.Selectable;

public class Attack implements UnitOrder{

	private Coordinates position;
	private int movingBehaviour;
	private Selectable target;
	
	public Attack (Coordinates position, int movingBehaviour, Selectable target) {
		this.movingBehaviour = movingBehaviour;
		this.position = position;
		this.target = target;
	}
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
	public String toString() {
		return "Attack [position=" + position + ", movingBehaviour=" + movingBehaviour
				+ ", target=" + target + "]";
	}
	
}
