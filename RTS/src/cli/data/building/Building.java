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
	private Coordinates rallyPoint;

	public Building(int maxHealth, Faction factionName, String name, Coordinates position,
			Description description, Coordinates rallyPoint) {
		super(maxHealth, factionName, name, position, description);
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
		return "Building [rallyPoint=" + rallyPoint + ", toString()=" + super.toString() + "]";
	}

}
