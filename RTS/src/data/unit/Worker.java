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
	private int contenerSize;

	public Worker(String name, String playerName, int maxHealth, int armorPoints, int armorType,
			String description, Coordinates position, int speed, Weapon weapon, int unitSize, int contenerSize) {
		super(name, playerName, maxHealth, armorPoints, armorType, description, position, speed, weapon);
		this.unitSize = unitSize;
		this.contenerSize = contenerSize;
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