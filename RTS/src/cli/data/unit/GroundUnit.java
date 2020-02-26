package cli.data.unit;

import cli.data.Coordinates;
/**
 * Abstract class representing the ground units such as foot soldiers or tanks
 * 
 * @author Awen
 *
 */
public class GroundUnit extends Unit {

	/**
	 * the space the unit takes
	 */
	private int unitSize;

	public GroundUnit(String name, int cost, String owner, int maxHealth, int armorPoints, int armorType,
			String description, Coordinates position, int speed, Weapon weapon, int unitSlots) {
		super(name, cost, owner, maxHealth, armorPoints, armorType, description, position, speed, weapon);
		this.unitSize = unitSlots;
	}

	/**
	 * the space the unit takes when inside something
	 */
	public int getUnitSlots() {
		return unitSize;
	}

	/**
	 * @param unitSlots how much space the unit takes
	 */
	public void setUnitSlots(int unitSlots) {
		this.unitSize = unitSlots;
	}

	@Override
	public String toString() {
		return super.toString() + "\nunitSlots = " + unitSize;
	}

}
