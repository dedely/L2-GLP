package cli.data.building;

import cli.data.Coordinates;

import cli.data.unit.Weapon;

/**
 * @author Adel
 *
 */
public class DefenseBuilding extends Building {

	private Weapon weapon;

	public DefenseBuilding(String name, int cost, String owner, int maxHealth, int armorPoints, int armorType,
			String description, Coordinates position, Size size, Weapon weapon) {
		super(name, cost, owner, maxHealth, armorPoints, armorType, description, position, size);
		this.weapon = weapon;
	}

	public Weapon getWeapon() {
		return weapon;
	}

	public void setWeapon(Weapon weapon) {
		this.weapon = weapon;
	}

	@Override
	public String toString() {
		return super.toString() + "\nweapon=" + weapon ;
	}

}