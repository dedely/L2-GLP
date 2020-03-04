package data.order;

import data.Constants;
import data.Coordinates;
import data.Selectable;

public class AttackPosition extends Order{

	private int movingBehaviour;
	private Coordinates targetedPosition;
	

	public AttackPosition(int movingBehaviour, Coordinates target) {
		this.movingBehaviour = movingBehaviour;
		this.targetedPosition= target;
		if (movingBehaviour==Constants.GO_AT_ALL_COST) {
			setType(Constants.ATTACK_POS_AAC);
		}
		else if (movingBehaviour==Constants.STOP_TO_SHOOT) {
			setType(Constants.ATTACK_POS_STS);
		}
	}
	public int getMovingBehaviour() {
		return movingBehaviour;
	}
	public void setMovingBehaviour(int movingBehaviour) {
		this.movingBehaviour = movingBehaviour;
	}

	public Coordinates getTargetedPosition() {
		return targetedPosition;
	}
	public void setTargetedPosition(Coordinates targetedPosition) {
		this.targetedPosition = targetedPosition;
	}
	public String toString() {
		return "Attack [movingBehaviour=" + movingBehaviour
				+ ", target=" + targetedPosition + "]";
	}
	
	
}
