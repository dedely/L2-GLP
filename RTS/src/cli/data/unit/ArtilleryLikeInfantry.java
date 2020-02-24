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

<<<<<<< Upstream, based on branch 'master' of https://github.com/Azilisiev/L2-GLP
<<<<<<< Upstream, based on branch 'master' of https://github.com/Azilisiev/L2-GLP
	public ArtilleryLikeInfantry(String name, Faction faction, int cost, int maxHealth, int armorPoints, int armorType,
			String description, Coordinates position, int speed, int damagePerShot, int typeOfDammage,
<<<<<<< Upstream, based on branch 'master' of https://github.com/Azilisiev/L2-GLP
			int timeBeetweenShots, int range, boolean canShootAtAirTarget, int unitSlots,
			int minimumRange) {
<<<<<<< Upstream, based on branch 'master' of https://github.com/Azilisiev/L2-GLP
<<<<<<< Upstream, based on branch 'master' of https://github.com/Azilisiev/L2-GLP
		super(name, faction, maxHealth, armorPoints, armorType, description, position, speed, damagePerShot,
				typeOfDammage, timeBeetweenShots, range, canShootAtAirTarget, unitSlots);
=======
=======
<<<<<<< Upstream, based on branch 'master' of https://github.com/JustAdel/L2-GLP
>>>>>>> c5f50c5 modified Units classes to be formated and added boolean hasMountedWeaponOrSecondary
=======
			int timeBeetweenShots, int range, boolean canShootAtAirTarget, int unitSlots, int minimumRange) {

>>>>>>> dd5b45e added all cost to Units classes
		super(name, faction, cost, maxHealth, armorPoints, armorType, description, position, speed, damagePerShot,
<<<<<<< Upstream, based on branch 'master' of https://github.com/Azilisiev/L2-GLP
				typeOfDammage, timeBeetweenShots, range, canShootTargetsOnDifferentHeight, unitSlots);
<<<<<<< Upstream, based on branch 'master' of https://github.com/Azilisiev/L2-GLP
>>>>>>> 263feca Changes to all Unit classes to match changes made in Selectable.
=======
=======
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
	public ArtilleryLikeInfantry(String name, int cost, Faction faction, int maxHealth, int currentHealth,
			int armorPoints, int armorType, boolean selected, String description, Coordinates position, int speed,
			int damagePerShot, int typeOfDammage, int timeBeetweenShots, int timeLeftToReload, int range,
			boolean canShootAtAirTarget, boolean hasSecondariesOrMounted, int unitSlots, int minimumRange) {
		super(name, cost, faction, maxHealth, currentHealth, armorPoints, armorType, selected, description, position,
				speed, damagePerShot, typeOfDammage, timeBeetweenShots, timeLeftToReload, range, canShootAtAirTarget,
				hasSecondariesOrMounted, unitSlots);
>>>>>>> 072884a modified the classes to have cost in their constructors
=======


	public ArtilleryLikeInfantry(String name, int cost, Faction faction, int maxHealth, int armorPoints, int armorType,
			String description, Coordinates position, int speed, int damagePerShot, int typeOfDammage,
			int timeBeetweenShots, int timeLeftToReload, int range, boolean canShootAtAirTarget,
			boolean hasSecondariesOrMounted, int unitSlots, int minimumRange) {
		super(name, cost, faction, maxHealth, armorPoints, armorType, description, position, speed, damagePerShot,
				typeOfDammage, timeBeetweenShots, timeLeftToReload, range, canShootAtAirTarget, hasSecondariesOrMounted,
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
