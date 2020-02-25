package cli.data.unit;

import cli.data.Coordinates;
import cli.data.faction.Faction;

/**
 * Generic TerrestrialVehicle, (basically tanks) but with a machine-gun on top
 * 
 * @author Awen
 *
 */

public class GroundUnitWithMountedWeapon extends GroundUnit {

	/**
	 * the infantry serving mounted weapon if any
	 */
	private GroundUnit infanteryIn;

	/**
	 * condition about if the weapon is installed or not
	 */
	private boolean mounted;

	/**
	 * the damage dealt by the mounted weapon
	 */
	private int mountedWeaponDamage;

	/**
	 * the number of ticks to reload the mounted weapon
	 */
	private int mountedWeapontimeBeetweenShots;
	private int mountedWeapontimeLeftToReload = 0;

	private boolean canShootAtAirTargetWithMounted;

	public GroundUnitWithMountedWeapon(String name, int cost, String playerName, int maxHealth, int armorPoints,
			int armorType, String description, Coordinates position, int speed, int damagePerShot, int typeOfDammage,
			int timeBeetweenShots, int range, boolean canShootAtAirTarget, boolean hasSecondariesOrMounted,
			int unitSlots, GroundUnit infanteryIn, boolean mounted, int mountedWeaponDamage,
			int mountedWeapontimeBeetweenShots, boolean canShootAtAirTargetWithMounted) {
		super(name, cost, playerName, maxHealth, armorPoints, armorType, description, position, speed, damagePerShot,
				typeOfDammage, timeBeetweenShots, range, canShootAtAirTarget, hasSecondariesOrMounted, unitSlots);
		this.infanteryIn = infanteryIn;
		this.mounted = mounted;
		this.mountedWeaponDamage = mountedWeaponDamage;
		this.mountedWeapontimeBeetweenShots = mountedWeapontimeBeetweenShots;
		this.canShootAtAirTargetWithMounted = canShootAtAirTargetWithMounted;
	}

	/**
	 * @return the infantry serving the mounted weapon if any
	 */
	public GroundUnit getInfanteryIn() {
		return infanteryIn;
	}

	/**
	 * @param infanteryIn the infantry that uses the mounted weapon
	 */
	public void setInfanteryIn(GroundUnit infanteryIn) {
		this.infanteryIn = infanteryIn;
	}

	/**
	 * @return return true if the weapon is installed, false otherwise
	 */
	public boolean isMounted() {
		return mounted;
	}

	/**
	 * @param Mounted the truth value of the weapon installation
	 */
	public void setMounted(boolean Mounted) {
		this.mounted = Mounted;
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
	 * @return the number ticks to reload the mounted weapon
	 */
	public int getMountedWeapontimeLeftToReload() {
		return mountedWeapontimeLeftToReload;
	}

	/**
	 * @param mountedWeaponFireRate the number of shots per seconds from the mounted
	 *                              weapon
	 */
	public void setMountedWeapontimeLeftToReload(int MountedWeapontimeLeftToReload) {
		this.mountedWeapontimeLeftToReload = MountedWeapontimeLeftToReload;
	}

	/**
	 * @return the number of shots per seconds from the mounted weapon
	 */
	public int getMountedWeapontimeBeetweenShots() {
		return mountedWeapontimeBeetweenShots;
	}

	/**
	 * @param mountedWeaponFireRate the number of shots per seconds from the mounted
	 *                              weapon
	 */
	public void setMountedWeapontimeBeetweenShots(int MountedWeapontimeBeetweenShots) {
		this.mountedWeapontimeBeetweenShots = MountedWeapontimeBeetweenShots;
	}

	public boolean isCanShootAtAirTargetWithMounted() {
		return canShootAtAirTargetWithMounted;
	}

	public void setCanShootAtAirTargetWithMounted(boolean canShootAtAirTargetWithMounted) {
		this.canShootAtAirTargetWithMounted = canShootAtAirTargetWithMounted;
	}

	@Override
	public String toString() {
		return super.toString() + "\nMounted = " + mounted + "\nmountedWeaponDamage = " + mountedWeaponDamage
				+ "\nMountedWeapontimeBeetweenShots = " + mountedWeapontimeBeetweenShots
				+ "\nMW can shoot at AirTarget = " + canShootAtAirTargetWithMounted;
	}

}
