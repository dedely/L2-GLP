package cli.data.building;

import cli.data.Coordinates;
import cli.data.Description;
import cli.data.faction.Faction;

/**
 * @author Adel
 *
 */
public class Barracks extends UnitFactory {

	public Barracks(int maxHealth, Faction factionName, String name, Coordinates position, Description description,
			Size size, Coordinates rallyPoint) {
		super(maxHealth, factionName, name, position, description, size, rallyPoint);
	}

	@Override
	public String toString() {
		return "Barracks [toString()=" + super.toString() + "]";
	}

}
