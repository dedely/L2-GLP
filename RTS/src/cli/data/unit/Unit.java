package cli.data.unit;

import cli.data.Selectable;
import cli.data.faction.Faction;
import cli.data.Coordinates;
import cli.data.Description;

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
	 * The number of shots per second
	 * 
	 */
	private float fireRate;

	/**
	 * The minimal distance between the unit and the target for it to shoot
	 * 
	 */
	private int range;

	public Unit(int health, int maxHealth, boolean selected, Faction factionName, String name, Coordinates position,
			Description description, int speed, int damagePerShot, float fireRate, int range) {
		super(health, maxHealth, selected, factionName, name, position, description);
		this.speed = speed;
		this.damagePerShot = damagePerShot;
		this.fireRate = fireRate;
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

	/**
	 * @return the number of shots per second
	 */
	public float getFireRate() {
		return fireRate;
	}

	/**
	 * @param fireRate how fast the unit fires (in shots/seconds)
	 */
	public void setFireRate(float fireRate) {
		this.fireRate = fireRate;
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
		return "Unit [speed=" + speed + ", damagePerShot=" + damagePerShot + ", fireRate=" + fireRate + ", range="
				+ range + ", toString()=" + super.toString() + "]";
	}
	
	

}
