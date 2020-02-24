package cli.data.unit;

import cli.data.Coordinates;
import cli.data.faction.Faction;

/**
 * The human workers
 * 
 * @author Awen
 *
 */
public class Worker extends Unit {

	/**
	 * the space the unit takes
	 */
	private int unitSlots;

	public Worker(String name, Faction faction, int cost, int maxHealth, int armorPoints, int armorType, String description,
			Coordinates position, int speed, int damagePerShot, int typeOfDammage, int timeBeetweenShots, int range,
<<<<<<< Upstream, based on branch 'master' of https://github.com/JustAdel/L2-GLP
			int unitSlots, boolean canShootTargetsOnDifferentHeight) {
		super(name, faction, cost, maxHealth, armorPoints, armorType, description, position, speed, damagePerShot,
				typeOfDammage, timeBeetweenShots, range, canShootTargetsOnDifferentHeight);
=======
			int unitSlots, boolean canShootAtAirTarget) {
		super(name, faction, maxHealth, armorPoints, armorType, description, position, speed, damagePerShot,
				typeOfDammage, timeBeetweenShots, range, canShootAtAirTarget);
>>>>>>> 2c156d2 modified Units classes to be formated and added boolean hasMountedWeaponOrSecondary
		this.unitSlots = unitSlots;
	}

	public int getUnitSlots() {
		return unitSlots;
	}

	public void setUnitSlots(int unitSlots) {
		this.unitSlots = unitSlots;
	}

	@Override
	public String toString() {
		return "Worker [unitSlots=" + unitSlots + "," + super.toString() + "]";
	}

}
