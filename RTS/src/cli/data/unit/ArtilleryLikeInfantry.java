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

	public ArtilleryLikeInfantry(String name, Faction faction, int cost, int maxHealth, int armorPoints, int armorType,
			String description, Coordinates position, int speed, int damagePerShot, int typeOfDammage,
			int timeBeetweenShots, int range, boolean canShootAtAirTarget, int unitSlots,
			int minimumRange) {
<<<<<<< Upstream, based on branch 'master' of https://github.com/JustAdel/L2-GLP
		super(name, faction, cost, maxHealth, armorPoints, armorType, description, position, speed, damagePerShot,
				typeOfDammage, timeBeetweenShots, range, canShootTargetsOnDifferentHeight, unitSlots);
=======
		super(name, faction, maxHealth, armorPoints, armorType, description, position, speed, damagePerShot,
				typeOfDammage, timeBeetweenShots, range, canShootAtAirTarget, unitSlots);
>>>>>>> 2c156d2 modified Units classes to be formated and added boolean hasMountedWeaponOrSecondary

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
