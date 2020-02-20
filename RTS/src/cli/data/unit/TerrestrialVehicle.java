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
	 * the space the vehicle takes when inside something
	 */
	private int unitSlots;

	public TerrestrialVehicle(int maxHealth, int armorPoints, int armorType, Faction faction, String name,
			Coordinates position, Description description, int speed, int damagePerShot, int timeBeetweenShots,
			int range, int positionState, int unitSlots) {
		super(maxHealth, armorPoints, armorType, faction, name, position, description, speed, damagePerShot,
				timeBeetweenShots, range, positionState);
		this.unitSlots = unitSlots;
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
		return "TerrestrialVehicle [ unitSlots=" + unitSlots + super.toString() + "]";
	}

}
