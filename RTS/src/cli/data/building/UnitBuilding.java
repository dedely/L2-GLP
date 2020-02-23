package cli.data.building;

import cli.data.Coordinates;
import cli.data.Description;
import cli.data.faction.Faction;

/**
 * @author Adel
 *
 */
public class UnitBuilding extends Building {
	Coordinates rallyPoint;

	public UnitBuilding(String name, Faction faction, int maxHealth, int armorPoints, int armorType, String description,
			Coordinates position, Size size, Coordinates rallyPoint) {
		super(name, faction, maxHealth, armorPoints, armorType, description, position, size);
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