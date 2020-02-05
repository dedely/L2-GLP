package cli.data.unit;

import cli.data.Coordinates;
import cli.data.Description;

/**
 * Artillery vehicle but with a weapon installable on top
 * 
 * @author Awen
 *
 */
public class ArtilleryWithMountedWeapon extends Artillery {

	/**
	 * the soldier operating the mounted weapon if any
	 */
	private Infantry infanteryIn;

	/**
	 * condition about if the weapon is installed or not
	 */
	private boolean Mounted;

	/**
	 * the damage dealt by the mounted weapon
	 */
	private int mountedWeaponDamage;

	/**
	 * the number of shots per seconds from the mounted weapon
	 */
	private int mountedWeaponFireRate;

	public ArtilleryWithMountedWeapon(int health, int maxHealth, boolean selected, String factionName, String name,
			Coordinates position, Description description, int speed, int damagePerShot, float fireRate, int range,
			boolean carried, int unitSlots, int minimumRange, Infantry infanteryIn, boolean mounted,
			int mountedWeaponDamage, int mountedWeaponFireRate) {
		super(health, maxHealth, selected, factionName, name, position, description, speed, damagePerShot, fireRate,
				range, carried, unitSlots, minimumRange);
		this.infanteryIn = infanteryIn;
		Mounted = mounted;
		this.mountedWeaponDamage = mountedWeaponDamage;
		this.mountedWeaponFireRate = mountedWeaponFireRate;
	}

	/**
	 * @return the Infantry operating the mounted weapon if any
	 */
	public Infantry getInfanteryIn() {
		return infanteryIn;
	}

	/**
	 * @param infanteryIn the Infantry operating the mounted weapon
	 */
	public void setInfanteryIn(Infantry infanteryIn) {
		this.infanteryIn = infanteryIn;
	}

	/**
	 * @return return true if the weapon is installed, false otherwise
	 */
	public boolean isMounted() {
		return Mounted;
	}

	/**
	 * @param isMounted the truth value of the weapon installation
	 */
	public void setMounted(boolean Mounted) {
		this.Mounted = Mounted;
	}

	/**
	 * @return the damage dealt by the mounted weapon by shot
	 */
	public int getMountedWeaponDamage() {
		return mountedWeaponDamage;
	}

	/**
	 * @param mountedWeaponDamage the damage dealt by the mounted weapon by shot
	 */
	public void setMountedWeaponDamage(int mountedWeaponDamage) {
		this.mountedWeaponDamage = mountedWeaponDamage;
	}

	/**
	 * @return the number of shots per seconds from the mounted weapon
	 */
	public int getMountedWeaponFireRate() {
		return mountedWeaponFireRate;
	}

	/**
	 * @param mountedWeaponFireRate the number of shots per seconds from the mounted
	 *                              weapon
	 */
	public void setMountedWeaponFireRate(int mountedWeaponFireRate) {
		this.mountedWeaponFireRate = mountedWeaponFireRate;
	}

}
