package process.factory;

import data.Constants;
import data.Coordinates;
import data.faction.Faction;
import data.unit.GroundUnit;
import data.unit.Unit;

public class UnitFactory {
	public static Unit createUnit(String type, Coordinates spawnPosition, Faction faction) throws IllegalArgumentException {
		if (type == Constants.TEST_GROUND) {
			return new GroundUnit("Test ground unit", 500, faction, 500, 0, Constants.SUPER_LIGHT,
					"A test unit", spawnPosition, 5, WeaponFactory.createWeapon(Constants.TEST_GROUND_WEAPON_H), 10);
		}

		throw new IllegalArgumentException("type " + type + " is not implemented or defined");

	}
}