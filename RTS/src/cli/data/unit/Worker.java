package cli.data.unit;

import cli.data.Coordinates;
import cli.data.Description;
import cli.data.faction.Faction;

/**
 * The units used to build and carry materials
 * 
 * @author Awen
 *
 */
public class Worker extends Unit {

	public Worker(int health, int maxHealth, boolean selected, Faction factionName, String name, Coordinates position,
			Description description, int speed, int damagePerShot, float fireRate, int range) {
		super(health, maxHealth, selected, factionName, name, position, description, speed, damagePerShot, fireRate,
				range);
		// TODO Auto-generated constructor stub
	}

}
