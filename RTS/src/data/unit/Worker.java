package data.unit;

import data.Coordinates;
import process.visitor.SelectableVisitor;

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

	public Worker(String name, int cost, String playerName, int maxHealth, int armorPoints, int armorType,
			String description, Coordinates position, int speed, Weapon weapon, int unitSize) {
		super(name, cost, playerName, maxHealth, armorPoints, armorType, description, position, speed, weapon);
		this.unitSize = unitSize;
	}

	public int getUnitSlots() {
		return unitSize;
	}

	public void setUnitSlots(int unitSlots) {
		this.unitSize = unitSlots;
	}

	@Override
	public <T> T accept(SelectableVisitor<T> visitor) {
		return visitor.visit(this);
	}

	@Override
	public String toString() {
		return super.toString() + "\nunit slots" + unitSize;
	}

}