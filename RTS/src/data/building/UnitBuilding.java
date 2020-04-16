package data.building;

import data.Coordinates;
import process.visitor.selectable.SelectableVisitor;

/**
 * @author Adel
 *
 */
public class UnitBuilding extends Building {
	Coordinates rallyPoint;

	public UnitBuilding(String name, String playerName, int maxHealth, int armorPoints, int armorType,
			String description, Coordinates position, Size size, Coordinates rallyPoint) {
		super(name, playerName, maxHealth, armorPoints, armorType, description, position, size);
		this.rallyPoint = rallyPoint;
	}

	public Coordinates getRallyPoint() {
		return rallyPoint;
	}

	public void setRallyPoint(Coordinates rallyPoint) {
		this.rallyPoint = rallyPoint;
	}

	@Override
	public <T> T accept(SelectableVisitor<T> visitor) {
		return visitor.visit(this);
	}

	@Override
	public String toString() {
		return "UnitFactory [rallyPoint=" + rallyPoint + ", toString()=" + super.toString() + "]";
	}
}