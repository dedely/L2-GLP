package process.executor;

import data.Coordinates;
import data.unit.Unit;
import process.CoordinatesTreatment;

public class Move implements Executor {

	private Unit unit;
	private Coordinates destination;

	public Move(Unit unit, Coordinates destination) {
		this.unit = unit;
		this.destination = destination;
	}

	@Override
	public boolean execute() {
		Coordinates newPosition = CoordinatesTreatment.positionNextTick(unit, destination);
		unit.setPosition(newPosition);
		return newPosition.equals(destination);
	}

}