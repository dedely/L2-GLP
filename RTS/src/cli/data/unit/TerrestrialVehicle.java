package cli.data.unit;

import cli.data.Coordinates;
import cli.data.Description;
import cli.data.faction.Faction;

/**
 * The abstract class representing all the mechanical terrestrial units
 * 
 * @author Awen
 *
 */
public abstract class TerrestrialVehicle extends Unit {

	/**
	 * the test attribute to know if the vehicle is inside something
	 */
	private boolean carried;

	/**
	 * the space the vehicle takes when inside something
	 */
	private int unitSlots;

	

	public TerrestrialVehicle(int maxHealth, Faction factionName, String name, Coordinates position,
			Description description, int speed, int damagePerShot, float fireRate, int range, boolean carried,
			int unitSlots) {
		super(maxHealth, factionName, name, position, description, speed, damagePerShot, fireRate, range);
		this.carried = carried;
		this.unitSlots = unitSlots;
	}

	/**
	 * @return true if the vehicle is inside something, false otherwise
	 */
	public boolean isCarried() {
		return carried;
	}

	/**
	 * @param carried the boolean value about if the vehicle is inside something
	 */
	public void setCarried(boolean carried) {
		this.carried = carried;
	}

	/**
	 * @return the space the vehicle takes when inside something
	 */
	public int getUnitSlots() {
		return unitSlots;
	}

	/**
	 * @param unitSlots how much space the vehicle takes
	 */
	public void setUnitSlots(int unitSlots) {
		this.unitSlots = unitSlots;
	}

	@Override
	public String toString() {
		return "TerrestrialVehicle [carried=" + carried + ", unitSlots=" + unitSlots + super.toString() + "]";
	}

}
