package cli.data.unit;

import cli.data.Coordinates;
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

<<<<<<< Upstream, based on branch 'master' of https://github.com/Azilisiev/L2-GLP
<<<<<<< Upstream, based on branch 'master' of https://github.com/Azilisiev/L2-GLP
<<<<<<< Upstream, based on branch 'master' of https://github.com/Azilisiev/L2-GLP
	public Artillery(String name, Faction faction, int cost, int maxHealth, int armorPoints, int armorType, String description,
			Coordinates position, int speed, int damagePerShot, int typeOfDammage, int timeBeetweenShots, int range,
<<<<<<< Upstream, based on branch 'master' of https://github.com/Azilisiev/L2-GLP
<<<<<<< Upstream, based on branch 'master' of https://github.com/Azilisiev/L2-GLP
			boolean canShootAtAirTarget, int unitSlots, int minimumRange) {
		super(name, faction, maxHealth, armorPoints, armorType, description, position, speed, damagePerShot,
				typeOfDammage, timeBeetweenShots, range, canShootAtAirTarget, unitSlots);
=======
=======
<<<<<<< Upstream, based on branch 'master' of https://github.com/JustAdel/L2-GLP
>>>>>>> c5f50c5 modified Units classes to be formated and added boolean hasMountedWeaponOrSecondary
			boolean canShootTargetsOnDifferentHeight, int unitSlots, int minimumRange) {
=======
	public Artillery(String name, Faction faction, int cost, int maxHealth, int armorPoints, int armorType,
			String description, Coordinates position, int speed, int damagePerShot, int typeOfDammage,
			int timeBeetweenShots, int range, boolean canShootAtAirTarget, int unitSlots, int minimumRange) {
>>>>>>> dd5b45e added all cost to Units classes
		super(name, faction, cost, maxHealth, armorPoints, armorType, description, position, speed, damagePerShot,
<<<<<<< Upstream, based on branch 'master' of https://github.com/Azilisiev/L2-GLP
				typeOfDammage, timeBeetweenShots, range, canShootTargetsOnDifferentHeight, unitSlots);
<<<<<<< Upstream, based on branch 'master' of https://github.com/Azilisiev/L2-GLP
>>>>>>> 263feca Changes to all Unit classes to match changes made in Selectable.
=======
=======
			boolean canShootAtAirTarget, int unitSlots, int minimumRange) {
		super(name, faction, maxHealth, armorPoints, armorType, description, position, speed, damagePerShot,
=======
>>>>>>> dd5b45e added all cost to Units classes
				typeOfDammage, timeBeetweenShots, range, canShootAtAirTarget, unitSlots);
<<<<<<< Upstream, based on branch 'master' of https://github.com/Azilisiev/L2-GLP
>>>>>>> 2c156d2 modified Units classes to be formated and added boolean hasMountedWeaponOrSecondary
>>>>>>> c5f50c5 modified Units classes to be formated and added boolean hasMountedWeaponOrSecondary
=======
>>>>>>> dd5b45e added all cost to Units classes
=======
	public Artillery(String name, int cost, Faction faction, int maxHealth, int currentHealth, int armorPoints,
			int armorType, boolean selected, String description, Coordinates position, int speed, int damagePerShot,
			int typeOfDammage, int timeBeetweenShots, int timeLeftToReload, int range, boolean canShootAtAirTarget,
=======

	public Artillery(String name, int cost, Faction faction, int maxHealth, int armorPoints, int armorType,
			String description, Coordinates position, int speed, int damagePerShot, int typeOfDammage,
<<<<<<< Upstream, based on branch 'master' of https://github.com/Azilisiev/L2-GLP
			int timeBeetweenShots, int timeLeftToReload, int range, boolean canShootAtAirTarget,
>>>>>>> 78ee734 modified (again) all units constructors to have costs
			boolean hasSecondariesOrMounted, int unitSlots, int minimumRange) {
<<<<<<< Upstream, based on branch 'master' of https://github.com/Azilisiev/L2-GLP
		super(name, cost, faction, maxHealth, currentHealth, armorPoints, armorType, selected, description, position,
				speed, damagePerShot, typeOfDammage, timeBeetweenShots, timeLeftToReload, range, canShootAtAirTarget,
				hasSecondariesOrMounted, unitSlots);
>>>>>>> 072884a modified the classes to have cost in their constructors
=======
=======
			int timeBeetweenShots, int range, boolean canShootAtAirTarget, int unitSlots, int minimumRange) {
>>>>>>> cdddd68 redone constructors of unit classes and of UnitFactory
		super(name, cost, faction, maxHealth, armorPoints, armorType, description, position, speed, damagePerShot,
				typeOfDammage, timeBeetweenShots, range, canShootAtAirTarget,
				unitSlots);
>>>>>>> 78ee734 modified (again) all units constructors to have costs
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
