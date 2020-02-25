package cli.data.unit;

import cli.data.Coordinates;
import cli.data.faction.Faction;

/**
 * The human workers
 * 
 * @author Awen
 *
 */
public class Worker extends Unit {

	/**
	 * the space the unit takes
	 */
	private int unitSlots;

	public Worker(String name, int cost, String playerName, int maxHealth, int armorPoints, int armorType,
			String description, Coordinates position, int speed, int damagePerShot, int damageType,
			int timeBeetweenShots, int range, int unitSlots) {
		super(name, cost, playerName, maxHealth, armorPoints, armorType, description, position, speed, damagePerShot,
				damageType, timeBeetweenShots, range);
		this.unitSlots = unitSlots;
	}

	public int getUnitSlots() {
		return unitSlots;
	}

	public void setUnitSlots(int unitSlots) {
		this.unitSlots = unitSlots;
	}

	@Override
	public String toString() {
		return "Worker [unitSlots=" + unitSlots + "," + super.toString() + "]";
	}

}
