package cli.data.building;

import cli.data.Coordinates;
import cli.data.Description;
import cli.data.faction.Faction;

/**
 * @author Adel
 *
 */
public abstract class UnitFactory extends Building {
	Coordinates rallyPoint;

	public UnitFactory(int maxHealth, Faction factionName, String name, Coordinates position, Description description,
			Size size, Coordinates rallyPoint) {
		super(maxHealth, factionName, name, position, description, size);
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
		return "UnitFactory [rallyPoint=" + rallyPoint + ", toString()=" + super.toString() + "]";
	}
}
