package cli.data.unit;

import cli.data.Coordinates;
import cli.data.faction.Faction;

/**
 * Abstract class representing the ground units such as foot soldiers or tanks
 * 
 * @author Awen
 *
 */
public class GroundUnit extends Unit {

	/**
	 * the space the unit takes
	 */
	private int unitSlots;

	public GroundUnit(String name, int cost, String playerName, int maxHealth, int armorPoints, int armorType,
			String description, Coordinates position, int speed, int damagePerShot, int damageType,
			int timeBeetweenShots, int range, int unitSlots) {
		super(name, cost, playerName, maxHealth, armorPoints, armorType, description, position, speed, damagePerShot,
				damageType, timeBeetweenShots, range);
		this.unitSlots = unitSlots;
	}

	/**
	 * the space the unit takes when inside something
	 */
	public int getUnitSlots() {
		return unitSlots;
	}

	/**
	 * @param unitSlots how much space the unit takes
	 */
	public void setUnitSlots(int unitSlots) {
		this.unitSlots = unitSlots;
	}

	@Override
	public String toString() {
		return super.toString() + "\nunitSlots = " + unitSlots;
	}

}
