package cli.process;

import cli.data.Coordinates;
import cli.data.unit.Unit;

public class MoveToTreatment {
	
	public static void moveToward(Unit unitToMove, Coordinates destination) {
		unitToMove.setPosition(CoordinatesTreatment.positionNextTick(unitToMove, destination));
	}
}
