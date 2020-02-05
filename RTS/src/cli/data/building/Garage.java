package cli.data.building;

import cli.data.Coordinates;
import cli.data.Description;
import cli.data.faction.Faction;

/**
 * @author Adel
 *
 */
public class Garage extends UnitFactory {

	public Garage(int health, int maxHealth, boolean selected, Faction factionName, String name, Coordinates position,
			Description description, Coordinates rallyPoint) {
		super(health, maxHealth, selected, factionName, name, position, description, rallyPoint);
	}

	@Override
	public String toString() {
		return "Garage [toString()=" + super.toString() + "]";
	}

}
