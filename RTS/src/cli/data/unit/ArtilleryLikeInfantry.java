package cli.data.unit;

import cli.data.Coordinates;
import cli.data.Description;
import cli.data.faction.Faction;

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

	public ArtilleryLikeInfantry(int maxHealth, int armorPoints, int armorType, Faction faction, String name,
			Coordinates position, Description description, int speed, int damagePerShot, int timeBeetweenShots,
			int range, int positionState, int unitSlots, int minimumRange) {
		super(maxHealth, armorPoints, armorType, faction, name, position, description, speed, damagePerShot,
				timeBeetweenShots, range, positionState, unitSlots);
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
		return "ArtilleryLikeInfantry [minimumRange=" + minimumRange + super.toString() + "]";
	}

}
