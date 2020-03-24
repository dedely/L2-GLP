package process.factory;

import java.util.ArrayList;

import data.Constants;
import data.Coordinates;
import data.building.Building;
import data.building.DefenseBuilding;
import data.building.ResearchBuilding;
import data.building.ResourceBuilding;
import data.building.Size;
import data.building.UnitBuilding;
import data.faction.Faction;
import data.resource.Resource;
import data.unit.Weapon;

public class BuildingFactory {

	public static Building createBuilding (String type, Coordinates spawnPosition, Faction faction, Size size) throws IllegalArgumentException {
		if (type == Constants.LABORATORY) {
			ArrayList<Integer> unlocksList = new ArrayList<Integer>();
			unlocksList.add(1);
			unlocksList.add(1);
			unlocksList.add(1);
			unlocksList.add(0);
			return new ResearchBuilding ("Laboratory", 500, faction, 1000, 0, Constants.LIGHT,
					"description", spawnPosition, size, unlocksList);
		}
		else if (type == Constants.SENTRY) {
			Weapon weapon = WeaponFactory.createWeapon(Constants.TEST_GROUND_WEAPON_H);
			return new DefenseBuilding (type, 500, faction, 2000, 0, 0, "description", spawnPosition, size, weapon);
		}
		else if ((type == Constants.BARRACKS) || (type == Constants.FACTORY)) {
			Coordinates coordinates = new Coordinates(10, 10, Constants.GROUND);
			return new UnitBuilding (type, 500, faction, 1000, 0, 0, "description", coordinates, size, coordinates);
		}
		else if (type == Constants.MINE) {
			Resource resource = new Resource(5, "mat");
			return new ResourceBuilding (type, 500, faction, 1000, 0, 0, "description", spawnPosition, size, resource, 50, 10);
		}
			
		throw new IllegalArgumentException("type " + type + " is not implemented or defined");
	}
	
	
	public static UnitBuilding createUnitBuilding(String type, Coordinates spawnPosition, Faction faction) {
		switch(type) {
		case Constants.HEADQUATERS: 
			return new UnitBuilding(Constants.HEADQUATERS, 0, faction, 1000, 0, 0, "hq", spawnPosition, new Size(3, 3), spawnPosition);
		default: 
			throw new IllegalArgumentException("Unknown UnitBuilding type: " + type);
		}
	}
}
