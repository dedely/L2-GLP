package data.building;

import data.Coordinates;
import data.unit.Weapon;
import process.visitor.selectable.SelectableVisitor;

/**
 * @author Adel
 *
 */
public class DefenseBuilding extends Building {

	private Weapon weapon;

	public DefenseBuilding(String name, String playerName, int maxHealth, int armorPoints, int armorType,
			String description, Coordinates position, Size size, Weapon weapon) {
		super(name, playerName, maxHealth, armorPoints, armorType, description, position, size);
		this.weapon = weapon;
	}

	public Weapon getWeapon() {
		return weapon;
	}

	public void setWeapon(Weapon weapon) {
		this.weapon = weapon;
	}

	@Override
	public <T> T accept(SelectableVisitor<T> visitor) {
		return visitor.visit(this);
	}

	@Override
	public String toString() {
		return super.toString() + "\nweapon=" + weapon;
	}

}