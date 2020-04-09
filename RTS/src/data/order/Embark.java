package data.order;

import data.Constants;
import data.Selectable;
import data.unit.Unit;
import process.visitor.OrderVisitor;

public class Embark extends Order {

	private Selectable target;
	private int movingBehaviour;

	public Embark(Selectable target, int movingBehaviour) {
		this.movingBehaviour = movingBehaviour;
		this.target = target;
		if (movingBehaviour == Constants.GO_AT_ALL_COST) {
			setType(Constants.EMBARK_AAC);
		} else if (movingBehaviour == Constants.STOP_TO_SHOOT) {
			setType(Constants.EMBARK_STS);
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

	public String toString() {
		return "Embark [target=" + target.getName() + ", moving behaviour=" + movingBehaviour + "]";
	}

	@Override
	public <T> T accept(OrderVisitor<T> visitor) {
		return visitor.visit(this);
	}

}
