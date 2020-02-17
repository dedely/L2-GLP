package cli.data.unit;

import cli.data.Coordinates;
import cli.data.Description;
import cli.data.faction.Faction;

/**
 * the class for instantiating Artillery support vehicles
 * 
 * @author Awen
 *
 */
public class Artillery extends TerrestrialVehicle {

	/**
	 * the minimum distance where the unit can fire
	 * 
	 */
	private int minimumRange;

	public Artillery(int maxHealth, Faction faction, String name, Coordinates position, Description description,
			int speed, int damagePerShot, int timeBeetweenShots, int range, int positionState, int unitSlots,
			int minimumRange) {
		super(maxHealth, faction, name, position, description, speed, damagePerShot, timeBeetweenShots, range,
				positionState, unitSlots);
		this.minimumRange = minimumRange;
	}

	/**
	 * @return the minimum distance where the unit can fire
	 */
	public int getMinimumRange() {
		return minimumRange;
	}

	/**
	 * @param minimumRange the closest distance between the unit and the target for
	 *                     it to be shoot-able
	 */
	public void setMinimumRange(int minimumRange) {
		this.minimumRange = minimumRange;
	}

	@Override
	public String toString() {
		return "Artillery [minimumRange=" + minimumRange + super.toString() + "]";
	}

}
