package cli.data.unit;

import cli.data.Coordinates;
import cli.data.faction.Faction;

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
	 * the number of shots per seconds from the mounted weapon
	 */
	private int mountedWeapontimeBeetweenShots;
	private int mountedWeapontimeLeftToReload;

	private boolean canShootAtAirTargetWithMounted;

	public ArtilleryWithMountedWeapon(String name, Faction faction, int cost, int maxHealth, int armorPoints,
			int armorType, String description, Coordinates position, int speed, int damagePerShot, int typeOfDammage,
			int timeBeetweenShots, int range, boolean canShootTargetsOnDifferentHeight, int unitSlots, int minimumRange,
			boolean mounted, int mountedWeaponDamage, int mountedWeapontimeBeetweenShots,
			boolean canShootAtAirTargetWithMounted) {
		super(name, faction, cost, maxHealth, armorPoints, armorType, description, position, speed, damagePerShot,
				typeOfDammage, timeBeetweenShots, range, canShootTargetsOnDifferentHeight, unitSlots, minimumRange);
		this.mounted = mounted;
		this.mountedWeaponDamage = mountedWeaponDamage;
		this.mountedWeapontimeBeetweenShots = mountedWeapontimeBeetweenShots;
		mountedWeapontimeLeftToReload = mountedWeapontimeBeetweenShots;
		setHasSecondariesOrMounted(true);
	}

	/**
	 * @return the Infantry operating the mounted weapon if any
	 */
	public GroundUnit getInfanteryIn() {
		return infanteryIn;
	}

	/**
	 * @param infanteryIn the Infantry operating the mounted weapon
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
	 * @param isMounted the truth value of the weapon installation
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
				+ "\nmountedWeapontimeBeetweenShots = " + mountedWeapontimeBeetweenShots
				+ "\nMW can shoot at AirTarget = " + canShootAtAirTargetWithMounted;
	}

}
