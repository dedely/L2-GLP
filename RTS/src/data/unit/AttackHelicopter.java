package data.unit;

import data.Coordinates;
import data.faction.Faction;

/**
 * Class for instantiating attack helis with multiple weapons
 * 
 * @author Awen
 *
 */
public class AttackHelicopter extends Unit {

	private Weapon secondaryWeapon;

	public AttackHelicopter(String name, int cost, Faction faction, int maxHealth, int armorPoints, int armorType,
			String description, Coordinates position, int speed, Weapon weapon, Weapon secondaryWeapon) {
		super(name, cost, faction, maxHealth, armorPoints, armorType, description, position, speed, weapon);
		this.secondaryWeapon = secondaryWeapon;
	}

	@Override
	public String toString() {
		return super.toString() + " \nsecondary Weapon = " + secondaryWeapon.toString();

	}

}