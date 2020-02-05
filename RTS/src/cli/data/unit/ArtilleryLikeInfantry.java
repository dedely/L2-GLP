package cli.data.unit;

import cli.data.Coordinates;
import cli.data.Description;

/**
 * the class for instantiating human unit with an indirect fire weapon
 * 
 * @author Awen
 *
 */
public class ArtilleryLikeInfantry extends Infantry {

	/**
	 * the minimum distance where the unit can fire
	 * 
	 */
	private int minimumRange;

	public ArtilleryLikeInfantry(int health, int maxHealth, boolean selected, String factionName, String name,
			Coordinates position, Description description, int speed, int damagePerShot, float fireRate, int range,
			boolean carried, int unitSlots, int minimumRange) {
		super(health, maxHealth, selected, factionName, name, position, description, speed, damagePerShot, fireRate,
				range, carried, unitSlots);
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
