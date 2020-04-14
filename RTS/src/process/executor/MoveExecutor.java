package process.executor;

import data.Coordinates;
import data.unit.Unit;
import process.CoordinatesTreatment;
import process.SelectableRepository;

public class MoveExecutor implements Executor {

	private Unit unit;
	private Coordinates destination;

	public MoveExecutor(Unit unit, Coordinates destination) {
		this.unit = unit;
		this.destination = destination;
	}

	@Override
	public boolean execute() {
		SelectableRepository r = SelectableRepository.getInstance();
		
		//r.updatePosition(this);
		return unit.getPosition().equals(destination);
	}

	public Unit getUnit() {
		return unit;
	}

	public Coordinates getDestination() {
		return destination;
	}
	
	public Coordinates getNewPosition() {
		return CoordinatesTreatment.positionNextTick(unit, destination);
	}

}