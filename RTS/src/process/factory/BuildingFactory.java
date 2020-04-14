package process.factory;

import data.Constants;
import data.Coordinates;
import data.building.Building;
import data.building.UnitBuilding;

public class BuildingFactory {

	public static Building createBuilding(String type, Coordinates spawnPosition, String faction)
			throws IllegalArgumentException {
		switch (type) {
		case Constants.HEADQUATERS:
			return createHeadQuaters(spawnPosition, faction);
		default:
			throw new IllegalArgumentException("Unknown building type : " + type);
		}
	}

	public static UnitBuilding createHeadQuaters(Coordinates spawnPosition, String faction)
			throws IllegalArgumentException {
		switch (faction) {
		case Constants.FEDERATION:
			return new UnitBuilding(Constants.HEADQUATERS, faction, 1000, 0, Constants.HEAVY, "HQ", spawnPosition,
					Constants.DEFAULT_SIZE, spawnPosition);
		case Constants.UNION:
			return new UnitBuilding(Constants.HEADQUATERS, faction, 1000, 0, Constants.HEAVY, "HQ", spawnPosition,
					Constants.DEFAULT_SIZE, spawnPosition);
		case Constants.REPUBLIC:
			return new UnitBuilding(Constants.HEADQUATERS, faction, 1000, 0, Constants.HEAVY, "HQ", spawnPosition,
					Constants.DEFAULT_SIZE, spawnPosition);
		default:
			throw new IllegalArgumentException("Unknown faction type : " + faction);
		}
	}
}