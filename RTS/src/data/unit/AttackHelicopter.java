package data.unit;

import data.Coordinates;
import process.visitor.SelectableVisitor;

/**
 * Class for instantiating attack helis with multiple weapons
 * 
 * @author Awen
 *
 */
public class AttackHelicopter extends Unit {

	private Weapon secondaryWeapon;

	public AttackHelicopter(String name, int cost, String playerName, int maxHealth, int armorPoints, int armorType,
			String description, Coordinates position, int speed, Weapon weapon, Weapon secondaryWeapon) {
		super(name, cost, playerName, maxHealth, armorPoints, armorType, description, position, speed, weapon);
		this.secondaryWeapon = secondaryWeapon;
	}

	@Override
	public <T> T accept(SelectableVisitor<T> visitor) {
		return visitor.visit(this);
	}

	@Override
	public String toString() {
		return super.toString() + " \nsecondary Weapon = " + secondaryWeapon.toString();

	}

}