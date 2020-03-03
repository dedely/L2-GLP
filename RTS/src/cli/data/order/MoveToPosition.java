package cli.data.order;

import cli.data.Constants;
import cli.data.Coordinates;
import cli.data.Selectable;
import cli.data.unit.Unit;

public class MoveToPosition extends Order{
	
	private Coordinates position;
	private int movingBehaviour;
	
	
	

	public MoveToPosition (Coordinates position, int movingBehaviour) {
		this.movingBehaviour = movingBehaviour;
		this.position = position;
		if (movingBehaviour==Constants.GO_AT_ALL_COST) {
			setType(Constants.MOVE_TO_POSITION_AAC);
		}
		else if (movingBehaviour==Constants.STOP_TO_SHOOT) {
			setType(Constants.MOVE_TO_POSITION_STS);
		}
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

	public String toString() {
		return "MoveTo [position=" + position + ", moving behaviour=" + movingBehaviour + "]";
	}
	
	
}
