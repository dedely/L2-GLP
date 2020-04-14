package process.executor;

import data.Coordinates;
import data.unit.Unit;
import process.CoordinatesTreatment;
import process.GameUtility;
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
		Coordinates pixelPosition = unit.getPosition();
		Coordinates actualPosition = GameUtility.convert(pixelPosition);
		Coordinates newPosition = getNewPosition();
		Coordinates actualNewPosition = GameUtility.convert(newPosition);
		if (!actualNewPosition.equals(actualPosition)) {
			if (isFree(actualNewPosition)) {
				unit.setPosition(newPosition);
				r.updatePosition(unit.getId(), actualPosition, actualNewPosition);
			}
		}else {
			unit.setPosition(newPosition);
		}

		return unit.getPosition().equals(destination);
	}

	private boolean isFree(Coordinates position) {
		SelectableRepository r = SelectableRepository.getInstance();
		return r.getIdByPosition(position) == null;
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