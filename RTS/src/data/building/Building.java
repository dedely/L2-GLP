package data.building;

import data.Coordinates;
import data.Selectable;
import data.faction.Faction;

/**
 * @author Adel
 *
 */

public abstract class Building extends Selectable {

	private Size size;

	public Building(String name, int cost, Faction faction, int maxHealth, int armorPoints, int armorType,
			String description, Coordinates position, Size size) {
		super(name, cost, faction, maxHealth, armorPoints, armorType, description, position);
		this.size = size;
	}

	public Size getSize() {
		return size;
	}

	public void setSize(Size size) {
		this.size = size;
	}

	@Override
	public String toString() {
		return "Building [size=" + size + ", toString()=" + super.toString() + "]";
	}
}