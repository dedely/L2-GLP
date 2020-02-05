package cli.data.building;

import cli.data.Coordinates;
import cli.data.Description;
import cli.data.Selectable;

public abstract class Building extends Selectable {
	private Coordinates rallyPoint;

	public Building(int health, int maxHealth, boolean selected, String factionName, String name, Coordinates position,
			Description description, Coordinates rallyPoint) {
		super(health, maxHealth, selected, factionName, name, position, description);
		this.rallyPoint = rallyPoint;
	}

	public Coordinates getRallyPoint() {
		return rallyPoint;
	}

	public void setRallyPoint(Coordinates rallyPoint) {
		this.rallyPoint = rallyPoint;
	}

	@Override
	public String toString() {
		return "Building [rallyPoint=" + rallyPoint + "]";
	}
	
}
