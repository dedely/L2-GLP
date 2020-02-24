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


	public AttackHelicopter(String name, Faction faction, int maxHealth, int armorPoints, int armorType, String description,
			Coordinates position, int speed, int damagePerShot, int typeOfDammage, int timeBeetweenShots, int range,
			boolean canShootAtAirTarget, int secondaryWeaponDamage, int secondaryTimeBetweenShots,
			int secondaryWeaponAmmount,int secondaryTypeOfDamage) {
		super(name, faction, maxHealth, armorPoints, armorType, description, position, speed, damagePerShot,
				typeOfDammage, timeBeetweenShots, range, canShootAtAirTarget);
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
