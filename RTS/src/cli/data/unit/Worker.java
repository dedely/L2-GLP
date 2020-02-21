package cli.data.unit;

import cli.data.Coordinates;
import cli.data.Description;
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

	public Worker(int maxHealth, int armorPoints, int armorType, Faction faction, String name, Coordinates position,
			Description description, int speed, int damagePerShot, int typeOfDammage, int timeBeetweenShots, int range,
			int unitSlots) {
		super(maxHealth, armorPoints, armorType, faction, name, position, description, speed, damagePerShot,
				typeOfDammage, timeBeetweenShots, range);
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
