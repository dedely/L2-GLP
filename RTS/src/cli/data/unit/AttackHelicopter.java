package cli.data.unit;

import cli.data.Coordinates;
import cli.data.Description;

/**
 * Class for instantiating attack helis with multiple weapons
 * 
 * @author Awen
 *
 */
public class AttackHelicopter extends AerialVehicles {

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

	public AttackHelicopter(int health, int maxHealth, boolean selected, String factionName, String name,
			Coordinates position, Description description, int speed, int damagePerShot, float fireRate, int range,
			int secondaryWeaponDamage, int secondaryWeaponFireRate, int secondaryWeaponAmmount,
			int secondaryWeaponReloadTime) {
		super(health, maxHealth, selected, factionName, name, position, description, speed, damagePerShot, fireRate,
				range);
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

}
