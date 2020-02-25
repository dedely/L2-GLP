package cli.data.unit;

import cli.data.Coordinates;
import cli.data.faction.Faction;

/**
 * Class for instantiating attack helis with multiple weapons
 * 
 * @author Awen
 *
 */
public class AttackHelicopter extends Unit {

	private Weapon secondaryWeapon;

	public AttackHelicopter(String name, Faction faction, int cost, int maxHealth, int armorPoints, int armorType,
			String description, Coordinates position, int speed, Weapon weapon, Weapon secondaryWeapon) {
		super(name, faction, cost, maxHealth, armorPoints, armorType, description, position, speed, weapon);
		this.secondaryWeapon = secondaryWeapon;
	}

	@Override
	public String toString() {
		return super.toString() + " \nsecondary Weapon = " + secondaryWeapon;

	}

}
