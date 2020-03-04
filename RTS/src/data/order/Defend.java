package cli.data.order;

import cli.data.Constants;
import cli.data.Coordinates;
import cli.data.Selectable;

public class Defend extends Order {

	private Coordinates position;
	private Selectable target;
	private int movingBehaviour;
	
	
	
	public Defend(Coordinates position, Selectable target, int movingBehaviour) {
		setType(Constants.DEFEND);
		this.position = position;
		this.target = target;
		this.movingBehaviour = movingBehaviour;
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
	public int getMovingBehaviour() {
		return movingBehaviour;
	}
	public void setMovingBehaviour(int movingBehaviour) {
		this.movingBehaviour = movingBehaviour;
	}


}
