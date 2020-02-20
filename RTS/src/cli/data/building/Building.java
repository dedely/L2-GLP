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

	public Building(int maxHealth, Faction factionName, String name, Coordinates position, Description description,
			Size size) {
		super(maxHealth, factionName, name, position, description);
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
