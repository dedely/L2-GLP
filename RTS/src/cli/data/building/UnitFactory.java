package cli.data.building;

import cli.data.Coordinates;
import cli.data.Description;
import cli.data.faction.Faction;

/**
 * @author Adel
 *
 */
public abstract class UnitFactory extends Building {

	public UnitFactory(int health, int maxHealth, boolean selected, Faction factionName, String name,
			Coordinates position, Description description, Coordinates rallyPoint) {
		super(health, maxHealth, selected, factionName, name, position, description, rallyPoint);
	}

}
