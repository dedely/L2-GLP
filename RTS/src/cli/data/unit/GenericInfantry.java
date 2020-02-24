package cli.data.unit;

import cli.data.Coordinates;
import cli.data.faction.Faction;

/**
 * the class for instantiating human unit with a direct fire weapon
 * 
 * @author Awen
 *
 */
public class GenericInfantry extends GroundUnit {

	public GenericInfantry(String name, Faction faction, int cost, int maxHealth, int armorPoints, int armorType, String description,
			Coordinates position, int speed, int damagePerShot, int typeOfDammage, int timeBeetweenShots, int range,
			boolean canShootTargetsOnDifferentHeight, int unitSlots) {
		super(name, faction, cost, maxHealth, armorPoints, armorType, description, position, speed, damagePerShot,
				typeOfDammage, timeBeetweenShots, range, canShootTargetsOnDifferentHeight, unitSlots);

	}

	@Override
	public String toString() {
		return super.toString();
	}

}
