package data.unit;

import data.Coordinates;
import data.faction.Faction;

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

	public GroundUnit(String name, int cost, Faction faction, int maxHealth, int armorPoints, int armorType,
			String description, Coordinates position, int speed, Weapon weapon, int unitSize) {
		super(name, cost, faction, maxHealth, armorPoints, armorType, description, position, speed, weapon);
		this.unitSize = unitSize;
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
