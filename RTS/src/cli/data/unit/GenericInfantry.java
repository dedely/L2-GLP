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

	public GenericInfantry(int maxHealth, Faction faction, String name, Coordinates position, Description description,
			int speed, int damagePerShot, int timeBeetweenShots, int range, int positionState, int unitSlots) {
		super(maxHealth, faction, name, position, description, speed, damagePerShot, timeBeetweenShots, range,
				positionState, unitSlots);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "GenericInfantry [" + super.toString() + "]";
	}

}
