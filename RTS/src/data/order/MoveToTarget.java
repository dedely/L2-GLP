package data.order;

import data.Constants;
import data.Coordinates;
import data.Selectable;
import data.unit.Unit;
import process.visitor.OrderVisitor;

public class MoveToTarget extends Order {

	private Selectable target;
	private int movingBehaviour;

	public MoveToTarget(Selectable target, int movingBehaviour) {
		this.movingBehaviour = movingBehaviour;
		this.target = target;
		if (movingBehaviour == Constants.GO_AT_ALL_COST) {
			setType(Constants.MOVE_TO_TARGET_AAC);
		} else if (movingBehaviour == Constants.STOP_TO_SHOOT) {
			setType(Constants.MOVE_TO_TARGET_STS);
		}
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

	public void setTarget(Unit target) {
		this.target = target;
	}

	@Override
	public <T> T accept(OrderVisitor<T> visitor) {
		return visitor.visit(this);
	}

	public String toString() {
		return "MoveTo [target=" + target.getName() + ", moving behaviour=" + movingBehaviour + "]";
	}

}
