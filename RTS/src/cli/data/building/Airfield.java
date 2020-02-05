package cli.data.building;

import cli.data.Coordinates;
import cli.data.Description;

public class Airfield extends UnitFactory{

	public Airfield(int health, int maxHealth, boolean selected, String factionName, String name, Coordinates position,
			Description description, Coordinates rallyPoint) {
		super(health, maxHealth, selected, factionName, name, position, description, rallyPoint);
	}

	@Override
	public String toString() {
		return "Airfield [toString()=" + super.toString() + "]";
	}
	
	
}
