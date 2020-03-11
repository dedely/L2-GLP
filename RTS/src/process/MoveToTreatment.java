package process;

import data.Coordinates;
import data.unit.Unit;

public class MoveToTreatment {

	public static void moveToward(Unit unitToMove, Coordinates destination) {
		Coordinates newPosition = CoordinatesTreatment.positionNextTick(unitToMove, destination);
		unitToMove.setPosition(newPosition);
	}
}