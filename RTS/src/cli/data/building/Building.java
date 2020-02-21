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

	public Building(int maxHealth, int armorPoints, int armorType, Faction faction, String name, Coordinates position,
			Description description) {
		super(maxHealth, armorPoints, armorType, faction, name, position, description);
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