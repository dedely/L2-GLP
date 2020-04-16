package process.factory;

import data.Constants;
import data.Coordinates;
import data.building.Size;
import data.building.UnitBuilding;
import data.unit.Unit;
import data.unit.Worker;

public class TestFactory {

	public static UnitBuilding createUnitBuilding(String type, String player, Coordinates position,
			Coordinates rallyPoint) throws IllegalArgumentException{
		switch (type) {
		case Constants.HEADQUATERS:
			return new UnitBuilding(type, player, 1000, 1000, Constants.HEAVY, "HQ", position, new Size(3, 3),
					rallyPoint);
		default:
			throw new IllegalArgumentException("Unknown building type : " + type);
		}
	}

	public static Unit createUnit(String type, String player, Coordinates position) throws IllegalArgumentException{
		switch (type) {
		case Constants.MCM:
			return new Worker(type, player, 100, 10, Constants.SUPER_LIGHT, "Worker", position, 2, null, 1, 5);
		default:
			throw new IllegalArgumentException("Unknown building type : " + type);
		}
	}
}