package cli.data.unit;

import cli.data.Coordinates;
import cli.data.Description;
import cli.data.faction.Faction;

/**
 * abstract class representing flying vehicles
 * 
 * @author Awen
 *
 */
public abstract class AerialVehicles extends Unit {

	public AerialVehicles(int maxHealth, int armorPoints, int armorType, Faction faction, String name,
			Coordinates position, Description description, int speed, int damagePerShot, int typeOfDammage,
			int timeBeetweenShots, int range) {
		super(maxHealth, armorPoints, armorType, faction, name, position, description, speed, damagePerShot, typeOfDammage,
				timeBeetweenShots, range);
		// TODO Auto-generated constructor stub
	}

	

	

}
