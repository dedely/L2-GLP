package process.executor;

import data.Coordinates;
import data.unit.Unit;
import process.CoordinatesTreatment;
import process.GameUtility;
import process.SelectableRepository;

/**
 * @author Adel
 *
 */
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
		boolean complete;
		Coordinates pixelPosition = unit.getPosition();
		Coordinates actualPosition = GameUtility.convert(pixelPosition);
		Coordinates newPosition = getNewPosition();
		Coordinates actualNewPosition = GameUtility.convert(newPosition);
		if (!actualNewPosition.equals(actualPosition)) {
			if (isFree(actualNewPosition)) {
				unit.setPosition(newPosition);
				r.updatePosition(unit.getId(), actualPosition, actualNewPosition);
				complete = unit.getPosition().equals(destination);
			}else {
				complete = true;
			}
		} else {
			unit.setPosition(newPosition);
			complete = unit.getPosition().equals(destination);
		}

		return complete;
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

	@Override
	public int getProgress() {
		return 0;
	}

}