package cli.data;

import cli.abstracts.Infantry;
import cli.abstracts.TerrestrialVehicle;

/**
 * Heavy TerrestrialVehicle, basically tanks but with a machine-gun on top
 * 
 * @author Awen
 *
 */

public class HeavyTVWithMountedWeapon extends HeavyTV {

	/**
	 * the infantry serving mounted weapon if any
	 */
	private Infantry infanteryIn;

	/**
	 * @return the infantry serving the mounted weapon if any
	 */
	public Infantry getInfanteryIn() {
		return infanteryIn;
	}

	/**
	 * @param infanteryIn the infantery that uses the mounted weapon
	 */
	public void setInfanteryIn(Infantry infanteryIn) {
		this.infanteryIn = infanteryIn;
	}

	public HeavyTVWithMountedWeapon(int speed, int damagePerShot, float fireRate, int range, boolean carried,
			int unitSlots, Infantry infanteryIn) {
		super(speed, damagePerShot, fireRate, range, carried, unitSlots);
		this.infanteryIn = infanteryIn;
	}

	

}
