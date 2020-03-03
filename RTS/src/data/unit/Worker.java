package data.unit;

import data.Coordinates;
import data.faction.Faction;

/**
 * The human workers
 * 
 * @author Awen
 *
 */
public class Worker extends Unit {

	/**
	 * the space the unit takes
	 */
	private int unitSize;

	public Worker(String name, int cost, Faction faction, int maxHealth, int armorPoints, int armorType,
			String description, Coordinates position, int speed, Weapon weapon, int unitSize) {
		super(name, cost, faction, maxHealth, armorPoints, armorType, description, position, speed, weapon);
		this.unitSize = unitSize;
	}

	public int getUnitSlots() {
		return unitSize;
	}

	public void setUnitSlots(int unitSlots) {
		this.unitSize = unitSlots;
	}

	@Override
	public String toString() {
		return super.toString() + "\nunit slots" + unitSize;
	}

}