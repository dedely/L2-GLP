package cli.data.building;

import cli.data.Coordinates;
import cli.data.Description;
import cli.data.Selectable;
import cli.data.faction.Faction;

/**
 * @author Adel
 *
 */
public abstract class Building extends Selectable {

	private Size size;


	public Building(String name, Faction faction, int maxHealth, int armorPoints, int armorType, String description,
			Coordinates position, Size size) {
		super(name, faction, maxHealth, armorPoints, armorType, description, position);
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