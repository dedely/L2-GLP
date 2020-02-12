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

	public AerialVehicles(int maxHealth, Faction factionName, String name, Coordinates position,
			Description description, int speed, int damagePerShot, float fireRate, int range) {
		super(maxHealth, factionName, name, position, description, speed, damagePerShot, fireRate, range);
		// TODO Auto-generated constructor stub
	}

	

	
}
