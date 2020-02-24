package cli.data.unit;

import cli.data.Coordinates;
import cli.data.faction.Faction;

/**
 * the class for instantiating human unit with an indirect fire weapon
 * 
 * @author Awen
 *
 */
public class ArtilleryLikeInfantry extends GroundUnit {

	/**
	 * the minimum distance where the unit can fire
	 * 
	 */
	private int minimumRange;

	public ArtilleryLikeInfantry(String name, int cost, Faction faction, int maxHealth, int currentHealth,
			int armorPoints, int armorType, boolean selected, String description, Coordinates position, int speed,
			int damagePerShot, int typeOfDammage, int timeBeetweenShots, int timeLeftToReload, int range,
			boolean canShootAtAirTarget, boolean hasSecondariesOrMounted, int unitSlots, int minimumRange) {
		super(name, cost, faction, maxHealth, currentHealth, armorPoints, armorType, selected, description, position,
				speed, damagePerShot, typeOfDammage, timeBeetweenShots, timeLeftToReload, range, canShootAtAirTarget,
				hasSecondariesOrMounted, unitSlots);
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
