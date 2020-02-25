package cli.data.unit;

import cli.data.Coordinates;


/**
 * Class for instantiating attack helis with multiple weapons
 * 
 * @author Awen
 *
 */
public class AttackHelicopter extends Unit {

	private Weapon secondaryWeapon;

	public AttackHelicopter(String name, int cost, String owner, int maxHealth, int armorPoints, int armorType,
			String description, Coordinates position, int speed, Weapon weapon, Weapon secondaryWeapon) {
		super(name, cost, owner, maxHealth, armorPoints, armorType, description, position, speed, weapon);
		this.secondaryWeapon = secondaryWeapon;
	}

	@Override
	public String toString() {
		return super.toString() + " \nsecondary Weapon = " + secondaryWeapon.toString();

	}

}