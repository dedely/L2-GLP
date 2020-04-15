package data.order;

import data.Constants;
import data.Coordinates;
import data.Selectable;
import process.visitor.OrderVisitor;

public class AttackSuicide extends Order {

	private int movingBehaviour;
	private Selectable targetedSelectable;
	private Coordinates targetedPosition;

	public AttackSuicide(int movingBehaviour, Selectable target) {
		this.movingBehaviour = movingBehaviour;
		this.targetedSelectable = target;
		if (movingBehaviour == Constants.GO_AT_ALL_COST) {
			setType(Constants.ATTACK_AAC);
		} else if (movingBehaviour == Constants.STOP_TO_SHOOT) {
			setType(Constants.ATTACK_STS);
		}
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

	public Coordinates getTargetedPosition() {
		return targetedPosition;
	}

	public void setTargetedPosition(Coordinates targetedPosition) {
		this.targetedPosition = targetedPosition;
	}

	@Override
	public <T> T accept(OrderVisitor<T> visitor) {
		return visitor.visit(this);
	}

	public String toString() {
		return "Attack [movingBehaviour=" + movingBehaviour + ", target=" + targetedSelectable + "]";
	}

}
