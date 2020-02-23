package cli.process;

import cli.data.Coordinates;
import cli.data.unit.Unit;

public class MoveToTreatment {
	
	public void moveToward(Unit unitToMove, Coordinates destination) {
		unitToMove.setPosition(CoordinatesTreatment.positionNextTick(unitToMove, destination));
	}
}
