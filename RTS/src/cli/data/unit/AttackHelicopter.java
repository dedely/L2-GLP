package cli.data.unit;

import cli.data.Coordinates;
import cli.data.Description;
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
	private int secondaryWeaponFireRate;

	/**
	 * how many shots the secondaries can do before reload
	 */
	private int secondaryWeaponAmmount;

	/**
	 * how long the secondaries take to reload
	 */
	private int secondaryWeaponReloadTime;

	public AttackHelicopter(int maxHealth, int armorPoints, int armorType, Faction faction, String name,
			Coordinates position, Description description, int speed, int damagePerShot, int typeOfDammage,
			int timeBeetweenShots, int range, int secondaryWeaponDamage, int secondaryWeaponFireRate,
			int secondaryWeaponAmmount, int secondaryWeaponReloadTime) {
		super(maxHealth, armorPoints, armorType, faction, name, position, description, speed, damagePerShot,
				typeOfDammage, timeBeetweenShots, range);
		this.secondaryWeaponDamage = secondaryWeaponDamage;
		this.secondaryWeaponFireRate = secondaryWeaponFireRate;
		this.secondaryWeaponAmmount = secondaryWeaponAmmount;
		this.secondaryWeaponReloadTime = secondaryWeaponReloadTime;
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
	 * @return the number of shots per seconds from the secondaries
	 */
	public int getSecondaryWeaponFireRate() {
		return secondaryWeaponFireRate;
	}

	/**
	 * @param secondaryWeaponFireRate the number of shots per seconds from the
	 *                                secondaries
	 */
	public void setSecondaryWeaponFireRate(int secondaryWeaponFireRate) {
		this.secondaryWeaponFireRate = secondaryWeaponFireRate;
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

	/**
	 * @return how long the secondaries take to reload
	 */
	public int getSecondaryWeaponReloadTime() {
		return secondaryWeaponReloadTime;
	}

	/**
	 * @param secondaryWeaponReloadTime how long the secondaries take to reload
	 */
	public void setSecondaryWeaponReloadTime(int secondaryWeaponReloadTime) {
		this.secondaryWeaponReloadTime = secondaryWeaponReloadTime;
	}

	@Override
	public String toString() {
		return super.toString() + "\nsecondaryWeaponDamage = " + secondaryWeaponDamage + "\nsecondaryWeaponFireRate = "
				+ secondaryWeaponFireRate + "\nsecondaryWeaponAmmount = " + secondaryWeaponAmmount
				+ "\nsecondaryWeaponReloadTime = " + secondaryWeaponReloadTime;
	}

}
