package cli.data.unit;

import cli.data.Coordinates;
import cli.data.Description;
import cli.data.faction.Faction;

/**
 * the class for instantiating human unit with a direct fire weapon
 * 
 * @author Awen
 *
 */
public class GenericInfantry extends Infantry {

	

	public GenericInfantry(int maxHealth, Faction factionName, String name, Coordinates position,
			Description description, int speed, int damagePerShot, float fireRate, int range, boolean carried,
			int unitSlots) {
		super(maxHealth, factionName, name, position, description, speed, damagePerShot, fireRate, range, carried, unitSlots);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "GenericInfantry [" + super.toString() + "]";
	}

}
