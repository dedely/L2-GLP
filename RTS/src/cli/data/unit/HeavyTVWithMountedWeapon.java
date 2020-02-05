package cli.data.unit;

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

	public HeavyTVWithMountedWeapon(int speed, int damagePerShot, float fireRate, int range, boolean carried,
			int unitSlots, Infantry infanteryIn, boolean Mounted, int mountedWeaponDamage,
			int mountedWeaponFireRate) {
		super(speed, damagePerShot, fireRate, range, carried, unitSlots);
		this.infanteryIn = infanteryIn;
		this.Mounted = Mounted;
		this.setMountedWeaponDamage(mountedWeaponDamage);
		this.setMountedWeaponFireRate(mountedWeaponFireRate);
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

}
