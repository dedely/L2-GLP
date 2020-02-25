package cli.data.building;

import cli.data.Coordinates;

/**
 * @author Adel
 *
 */
public class UnitBuilding extends Building {
	Coordinates rallyPoint;

	public UnitBuilding(String name, int cost, String owner, int maxHealth, int armorPoints, int armorType,
			String description, Coordinates position, Size size, Coordinates rallyPoint) {
		super(name, cost, owner, maxHealth, armorPoints, armorType, description, position, size);
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