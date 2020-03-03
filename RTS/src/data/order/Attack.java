package data.order;

import data.Coordinates;
import data.Selectable;

public class Attack implements UnitOrder{

	private Coordinates position;
	private int movingBehaviour;
	private Selectable targetedSelectable;
	
	public Attack (int movingBehaviour, Selectable target) {
		this.movingBehaviour = movingBehaviour;
		this.targetedSelectable = target;
	}
	public int getMovingBehaviour() {
		return movingBehaviour;
	}
	public void setMovingBehaviour(int movingBehaviour) {
		this.movingBehaviour = movingBehaviour;
	}
	public Selectable getTarget() {
		return targetedSelectable;
	}
	public void setTarget(Selectable target) {
		this.targetedSelectable = target;
	}
	public String toString() {
		return "Attack [position=" + position + ", movingBehaviour=" + movingBehaviour
				+ ", target=" + targetedSelectable + "]";
	}
	
}
