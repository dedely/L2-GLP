package cli.data.unit;

import cli.data.Selectable;
import cli.data.faction.Faction;
import cli.data.Coordinates;

/**
 * the abstract class representing all mobile objects
 * 
 * @author Awen
 * 
 *
 */
public abstract class Unit extends Selectable {

	/**
	 * Attribute depicting how fast a unit moves on the map
	 * 
	 */
	private int speed;

	/**
	 * The amount of damage dealt by the unit in one shot
	 * 
	 */
	private int damagePerShot;

	/**
	 * Whether it is Light, SuperLight or heavy armor
	 * 
	 */
	private int damageType;

	/**
	 * The number of ticks between shots
	 * 
	 */
	private int timeBeetweenShots;
	private int timeLeftToReload = 0;

	/**
	 * The minimal distance between the unit and the target for it to shoot
	 * 
	 */
	private int range;

	public Unit(String name, int cost, String playerName, int maxHealth, int armorPoints, int armorType,
			String description, Coordinates position, int speed, int damagePerShot, int damageType,
			int timeBeetweenShots, int range) {
		super(name, cost, playerName, maxHealth, armorPoints, armorType, description, position);
		this.speed = speed;
		this.damagePerShot = damagePerShot;
		this.damageType = damageType;
		this.timeBeetweenShots = timeBeetweenShots;
		this.range = range;
	}

	/**
	 * @return the attribute depicting how fast a unit moves on the map
	 */
	public int getSpeed() {
		return speed;
	}

	/**
	 * @param speed the speed to give to the unit
	 */
	public void setSpeed(int speed) {
		this.speed = speed;
	}

	/**
	 * @return the amount of damage dealt by the unit in one shot
	 */
	public int getDamagePerShot() {
		return damagePerShot;
	}

	/**
	 * @param damagePerShot the damage the unit will deal when it fires
	 */
	public void setDamagePerShot(int damagePerShot) {
		this.damagePerShot = damagePerShot;
	}

	public int getDamageType() {
		return damageType;
	}

	public void setDamageType(int damageType) {
		this.damageType = damageType;
	}

	/**
	 * @return the time between two shots
	 */
	public int getTimeBeetweenShots() {
		return timeBeetweenShots;
	}

	/**
	 * @param timeBeetweenShots time between two shots
	 */
	public void setTimeBeetweenShots(int timeBeetweenShots) {
		this.timeBeetweenShots = timeBeetweenShots;
	}

	/**
	 * @return the number of ticks before the unit can shoot
	 */
	public int getTimeLeftToReload() {
		return timeLeftToReload;
	}

	/**
	 * @param fireRate how many ticks before the unit can shoot
	 */
	public void setTimeLeftToReload(int timeLeftToReload) {
		this.timeLeftToReload = timeLeftToReload;
	}

	/**
	 * @return the minimal distance between the unit and the target for it to shoot
	 */
	public int getRange() {
		return range;
	}

	/**
	 * @param range how close a unit needs to be before shooting
	 */
	public void setRange(int range) {
		this.range = range;
	}

	@Override
	public String toString() {
		return "Unit [speed=" + speed + ", damagePerShot=" + damagePerShot + ", damageType=" + damageType
				+ ", timeBeetweenShots=" + timeBeetweenShots + ", timeLeftToReload=" + timeLeftToReload + ", range="
				+ range + "]";
	}

}