package cli.data.unit;

import cli.data.Coordinates;
import cli.data.Description;

/**
 * Abstract class representing the foot soldiers of various types.
 * 
 * @author Awen
 *
 */
public abstract class Infantry extends Unit {

	/**
	 * boolean to know whether the unit is inside something
	 */
	private boolean carried;

	/**
	 * the space the unit takes
	 */
	private int unitSlots;

	public Infantry(int health, int maxHealth, boolean selected, String factionName, String name, Coordinates position,
			Description description, int speed, int damagePerShot, float fireRate, int range, boolean carried,
			int unitSlots) {
		super(health, maxHealth, selected, factionName, name, position, description, speed, damagePerShot, fireRate,
				range);
		this.carried = carried;
		this.unitSlots = unitSlots;
	}

	/**
	 * @return true if the infantry unit is inside something
	 */
	public boolean isCarried() {
		return carried;
	}

	/**
	 * @param carried boolean showing if the infantry unit is in a building/vehicle
	 */
	public void setCarried(boolean carried) {
		this.carried = carried;
	}

	/**
	 * the space the infantry unit takes when inside something
	 */
	public int getUnitSlots() {
		return unitSlots;
	}

	/**
	 * @param unitSlots how much space the infantry unit takes
	 */
	public void setUnitSlots(int unitSlots) {
		this.unitSlots = unitSlots;
	}

}
