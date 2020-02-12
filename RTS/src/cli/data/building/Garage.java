package cli.data.building;

import cli.data.Coordinates;
import cli.data.Description;
import cli.data.faction.Faction;

/**
 * @author Adel
 *
 */
public class Garage extends UnitFactory {

	public Garage(int maxHealth, Faction factionName, String name, Coordinates position, Description description,
			Size size, Coordinates rallyPoint) {
		super(maxHealth, factionName, name, position, description, size, rallyPoint);
	}

	@Override
	public String toString() {
		return "Garage [toString()=" + super.toString() + "]";
	}

}
