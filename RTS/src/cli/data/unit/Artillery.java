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
public class Artillery extends GroundUnit {

	/**
	 * the minimum distance where the unit can fire
	 * 
	 */
	private int minimumRange;

	public Artillery(int maxHealth, int armorPoints, int armorType, Faction faction, String name, Coordinates position,
			Description description, int speed, int damagePerShot, int typeOfDammage, int timeBeetweenShots, int range,
			int unitSlots, int minimumRange) {
		super(maxHealth, armorPoints, armorType, faction, name, position, description, speed, damagePerShot,
				typeOfDammage, timeBeetweenShots, range, unitSlots);
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
		return super.toString() + "\nminimumRange = " + minimumRange;
	}

}
