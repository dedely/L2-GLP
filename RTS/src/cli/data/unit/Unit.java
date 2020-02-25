package cli.data.unit;

import cli.data.Selectable;
import cli.data.faction.Faction;
import cli.data.Coordinates;

/**
 * the abstract class representing all mobile objects
 * 
 * @author Awen
 * 
 *
 */
public abstract class Unit extends Selectable {

	/**
	 * Attribute depicting how fast a unit moves on the map
	 * 
	 */
	private int speed;

	/**
	 * The amount of damage dealt by the unit in one shot
	 * 
	 */
	private Weapon weapon;
	
	public Unit(String name, Faction faction, int cost, int maxHealth,int armorPoints,int armorType, String description, Coordinates position,  int speed,
			Weapon weapon) {
		super(name, cost, faction, maxHealth, armorPoints, armorType, description, position);
		this.speed = speed;
		this.setWeapon(weapon);
	}

	


	/**
	 * @return the attribute depicting how fast a unit moves on the map
	 */
	public int getSpeed() {
		return speed;
	}

	/**
	 * @param speed the speed to give to the unit
	 */
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
	public Weapon getWeapon() {
		return weapon;
	}




	public void setWeapon(Weapon weapon) {
		this.weapon = weapon;
	}


	@Override
	public String toString() {
		return super.toString()+"\nspeed = " + speed +"\nweapon" + getWeapon().toString();
	}










	
}
