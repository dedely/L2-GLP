package cli.data.unit;

import cli.data.Coordinates;
import cli.data.Description;
import cli.data.faction.Faction;

/**
 * Heavy TerrestrialVehicle, basically tanks but with a machine-gun on top
 * 
 * @author Awen
 *
 */

public class HeavyTVWithMountedWeapon extends HeavyTV {

	/**
	 * the infantry serving mounted weapon if any
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

	public HeavyTVWithMountedWeapon(int health, int maxHealth, boolean selected, Faction factionName, String name,
			Coordinates position, Description description, int speed, int damagePerShot, float fireRate, int range,
			boolean carried, int unitSlots, Infantry infanteryIn, boolean mounted, int mountedWeaponDamage,
			int mountedWeaponFireRate) {
		super(health, maxHealth, selected, factionName, name, position, description, speed, damagePerShot, fireRate,
				range, carried, unitSlots);
		this.infanteryIn = infanteryIn;
		Mounted = mounted;
		this.mountedWeaponDamage = mountedWeaponDamage;
		this.mountedWeaponFireRate = mountedWeaponFireRate;
	}

	/**
	 * @return the infantry serving the mounted weapon if any
	 */
	public Infantry getInfanteryIn() {
		return infanteryIn;
	}

	/**
	 * @param infanteryIn the infantry that uses the mounted weapon
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
	 * @param Mounted the truth value of the weapon installation
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

	@Override
	public String toString() {
		return "HeavyTVWithMountedWeapon [infanteryIn=" + infanteryIn + ", Mounted=" + Mounted
				+ ", mountedWeaponDamage=" + mountedWeaponDamage + ", mountedWeaponFireRate=" + mountedWeaponFireRate
				+ super.toString() + "]";
	}

}
