package cli.process.factory;

import cli.data.Constants;

import cli.data.Coordinates;

import cli.data.faction.Faction;

import cli.data.unit.Unit;
import cli.data.unit.GroundUnit;

public class UnitFactory {
	public static Unit create(String type, Coordinates spawnPosition, Faction faction) throws IllegalArgumentException {
		if (type == Constants.TEST_GROUND) {
			return new GroundUnit("Test ground unit", 500, faction, 500, 0, Constants.SUPER_LIGHT,
					"A test unit", spawnPosition, 20, WeaponFactory.createWeapon(Constants.TEST_GROUND_WEAPON_H), 10);
		}

		throw new IllegalArgumentException("type " + type + " is not implemented or defined");

	}
}