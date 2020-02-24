package cli.data.unit;

import cli.data.Coordinates;
import cli.data.faction.Faction;

/**
 * Class for instantiating attack helis with multiple weapons
 * 
 * @author Awen
 *
 */
public class AttackHelicopter extends Unit {

	/**
	 * the damage dealt by the secondary weapon
	 */
	private int secondaryWeaponDamage;

	/**
	 * the number of shots per seconds from the secondaries
	 */
	private int secondaryWeaponAmmount;

	/**
	 * how long the secondaries take to reload
	 */
	private int secondaryTimeBetweenShots;

	private int secondaryTypeOfDamage;

<<<<<<< Upstream, based on branch 'master' of https://github.com/Azilisiev/L2-GLP
<<<<<<< Upstream, based on branch 'master' of https://github.com/Azilisiev/L2-GLP
<<<<<<< Upstream, based on branch 'master' of https://github.com/Azilisiev/L2-GLP

	public AttackHelicopter(String name, Faction faction, int cost, int maxHealth, int armorPoints, int armorType, String description,
			Coordinates position, int speed, int damagePerShot, int typeOfDammage, int timeBeetweenShots, int range,
<<<<<<< Upstream, based on branch 'master' of https://github.com/Azilisiev/L2-GLP
<<<<<<< Upstream, based on branch 'master' of https://github.com/Azilisiev/L2-GLP
			boolean canShootAtAirTarget, int secondaryWeaponDamage, int secondaryTimeBetweenShots,
			int secondaryWeaponAmmount,int secondaryTypeOfDamage) {
		super(name, faction, maxHealth, armorPoints, armorType, description, position, speed, damagePerShot,
				typeOfDammage, timeBeetweenShots, range, canShootAtAirTarget);
=======
=======
<<<<<<< Upstream, based on branch 'master' of https://github.com/JustAdel/L2-GLP
>>>>>>> c5f50c5 modified Units classes to be formated and added boolean hasMountedWeaponOrSecondary
			boolean canShootTargetsOnDifferentHeight, int secondaryWeaponDamage, int secondaryWeaponFireRate,
			int secondaryWeaponAmmount, int secondaryWeaponReloadTime) {
=======
	public AttackHelicopter(String name, Faction faction, int cost, int maxHealth, int armorPoints, int armorType,
			String description, Coordinates position, int speed, int damagePerShot, int typeOfDammage,
			int timeBeetweenShots, int range, boolean canShootAtAirTarget, int secondaryWeaponDamage,
			int secondaryTimeBetweenShots, int secondaryWeaponAmmount, int secondaryTypeOfDamage) {
>>>>>>> dd5b45e added all cost to Units classes
		super(name, faction, cost, maxHealth, armorPoints, armorType, description, position, speed, damagePerShot,
<<<<<<< Upstream, based on branch 'master' of https://github.com/Azilisiev/L2-GLP
				typeOfDammage, timeBeetweenShots, range, canShootTargetsOnDifferentHeight);
<<<<<<< Upstream, based on branch 'master' of https://github.com/Azilisiev/L2-GLP
>>>>>>> 263feca Changes to all Unit classes to match changes made in Selectable.
=======
=======
			boolean canShootAtAirTarget, int secondaryWeaponDamage, int secondaryTimeBetweenShots,
			int secondaryWeaponAmmount,int secondaryTypeOfDamage) {
		super(name, faction, maxHealth, armorPoints, armorType, description, position, speed, damagePerShot,
=======
>>>>>>> dd5b45e added all cost to Units classes
				typeOfDammage, timeBeetweenShots, range, canShootAtAirTarget);
<<<<<<< Upstream, based on branch 'master' of https://github.com/Azilisiev/L2-GLP
>>>>>>> 2c156d2 modified Units classes to be formated and added boolean hasMountedWeaponOrSecondary
>>>>>>> c5f50c5 modified Units classes to be formated and added boolean hasMountedWeaponOrSecondary
=======
>>>>>>> dd5b45e added all cost to Units classes
=======
	public AttackHelicopter(String name, int cost, Faction faction, int maxHealth, int currentHealth, int armorPoints,
			int armorType, boolean selected, String description, Coordinates position, int speed, int damagePerShot,
			int typeOfDammage, int timeBeetweenShots, int timeLeftToReload, int range, boolean canShootAtAirTarget,
=======


	public AttackHelicopter(String name, int cost, Faction faction, int maxHealth, int armorPoints, int armorType,
			String description, Coordinates position, int speed, int damagePerShot, int typeOfDammage,
			int timeBeetweenShots, int timeLeftToReload, int range, boolean canShootAtAirTarget,
>>>>>>> 78ee734 modified (again) all units constructors to have costs
			boolean hasSecondariesOrMounted, int secondaryWeaponDamage, int secondaryWeaponAmmount,
			int secondaryTimeBetweenShots, int secondaryTypeOfDamage) {
		super(name, cost, faction, maxHealth, armorPoints, armorType, description, position, speed, damagePerShot,
				typeOfDammage, timeBeetweenShots, timeLeftToReload, range, canShootAtAirTarget,
				hasSecondariesOrMounted);
>>>>>>> 072884a modified the classes to have cost in their constructors
		this.secondaryWeaponDamage = secondaryWeaponDamage;
		this.secondaryWeaponAmmount = secondaryWeaponAmmount;
		this.secondaryTimeBetweenShots = secondaryTimeBetweenShots;
		this.setSecondaryTypeOfDamage(secondaryTypeOfDamage);
		setHasSecondariesOrMounted(true);
	}


	/**
	 * @return the damage dealt by the secondary weapon
	 */
	public int getSecondaryWeaponDamage() {
		return secondaryWeaponDamage;
	}

	/**
	 * @param secondaryWeaponDamage the damage dealt by the secondary weapon
	 */
	public void setSecondaryWeaponDamage(int secondaryWeaponDamage) {
		this.secondaryWeaponDamage = secondaryWeaponDamage;
	}

	/**
	 * @return the number of ticks between shots
	 */
	public int getSecondaryTimeBetweenShots() {
		return secondaryTimeBetweenShots;
	}

	/**
	 * @param secondaryWeaponFireRate the number of shots per seconds from the
	 *                                secondaries
	 */
	public void setSecondaryTimeBetweenShots(int secondaryTimeBetweenShots) {
		this.secondaryTimeBetweenShots = secondaryTimeBetweenShots;
	}

	/**
	 * @return how many shots the secondaries can do before reload
	 */
	public int getSecondaryWeaponAmmount() {
		return secondaryWeaponAmmount;
	}

	/**
	 * @param secondaryWeaponAmmount how many shots the secondaries can do before
	 *                               reload
	 */
	public void setSecondaryWeaponAmmount(int secondaryWeaponAmmount) {
		this.secondaryWeaponAmmount = secondaryWeaponAmmount;
	}

	public int getSecondaryTypeOfDamage() {
		return secondaryTypeOfDamage;
	}

	public void setSecondaryTypeOfDamage(int secondaryTypeOfDamage) {
		this.secondaryTypeOfDamage = secondaryTypeOfDamage;
	}

	@Override
	public String toString() {
		return super.toString() + "\nsecondaryWeaponDamage = " + secondaryWeaponDamage + "\nsecondaryWeaponFireRate = "
				+ secondaryTimeBetweenShots + "\nsecondaryWeaponAmmount = " + secondaryWeaponAmmount
				+ "\nsecondaryWeaponReloadTime = ";
	}

}
