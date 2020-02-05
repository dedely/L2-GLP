package cli.data.building;

import cli.data.Coordinates;
import cli.data.Description;

public abstract class UnitFactory extends Building{

	public UnitFactory(int health, int maxHealth, boolean selected, String factionName, String name,
			Coordinates position, Description description, Coordinates rallyPoint) {
		super(health, maxHealth, selected, factionName, name, position, description, rallyPoint);
	}
	
}
