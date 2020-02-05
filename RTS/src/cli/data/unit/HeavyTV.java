package cli.data.unit;

import cli.data.Coordinates;
import cli.data.Description;

/**
 * Heavy terrestrial vehicle, basically tanks
 * 
 * @author Awen
 *
 */
public class HeavyTV extends TerrestrialVehicle {

	public HeavyTV(int health, int maxHealth, boolean selected, String factionName, String name, Coordinates position,
			Description description, int speed, int damagePerShot, float fireRate, int range, boolean carried,
			int unitSlots) {
		super(health, maxHealth, selected, factionName, name, position, description, speed, damagePerShot, fireRate,
				range, carried, unitSlots);
		// TODO Auto-generated constructor stub
	}

}
