
package process.treatment;

import data.Coordinates;
import data.Selectable;
import data.unit.Unit;

public class EmbarkTreatment {

	public static void embark(Unit unitToMove, Selectable destination) {
		if(CoordinatesTreatment.distance(unitToMove.getPosition(), destination.getPosition())>3) {
		Coordinates newPosition = CoordinatesTreatment.positionNextTick(unitToMove, destination.getPosition());
		unitToMove.setPosition(newPosition);
		}
		else {
			SelectableTreatment.getIn(unitToMove, destination);
		}
	}
}
