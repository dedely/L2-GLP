package cli.data.order;

import cli.data.Coordinates;

public class MoveTo implements UnitOrder{
	
	private Coordinates position;
	private int movingBehaviour;
	
	public MoveTo (Coordinates position, int movingBehaviour) {
		this.movingBehaviour = movingBehaviour;
		this.position = position;
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
