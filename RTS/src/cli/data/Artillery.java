package cli.data;

import cli.abstracts.TerrestrialVehicle;

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

	public Artillery(int speed, int damagePerShot, float fireRate, int range, boolean carried,
			int unitSlots, int minimumRange) {
		super(speed, damagePerShot, fireRate, range, carried, unitSlots);
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

}
