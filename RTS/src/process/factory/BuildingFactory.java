package process.factory;

import data.Constants;
import data.Coordinates;
import data.building.Building;
import data.building.UnitBuilding;
import data.faction.Faction;

public class BuildingFactory {

	
	public static Building createBuilding(String type, Coordinates spawnPosition, Faction faction)
			throws IllegalArgumentException {
		switch (type) {
		case Constants.HEADQUATERS:
			return createHeadQuaters(spawnPosition, faction);			
		default:
			throw new IllegalArgumentException("Unknown building type : " + type);
		}
	}
	
	
	public static UnitBuilding createHeadQuaters(Coordinates spawnPosition, Faction faction)
			throws IllegalArgumentException {
		switch (faction.getName()) {
		case Constants.FEDERATION:
			return new UnitBuilding(Constants.HEADQUATERS, 0, faction, 1000, 0, Constants.HEAVY, "HQ", spawnPosition, Constants.DEFAULT_SIZE, spawnPosition);
		case Constants.UNION:
			return new UnitBuilding(Constants.HEADQUATERS,  0, faction, 1000, 0, Constants.HEAVY, "HQ", spawnPosition, Constants.DEFAULT_SIZE, spawnPosition);
		case Constants.REPUBLIC:
			return new UnitBuilding(Constants.HEADQUATERS,  0, faction, 1000, 0, Constants.HEAVY, "HQ", spawnPosition, Constants.DEFAULT_SIZE, spawnPosition);
		default:
			throw new IllegalArgumentException("Unknown faction type : " + faction.getName());
		}
	}
}