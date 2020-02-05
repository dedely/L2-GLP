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
public class WorkerInfantery extends Worker {

	/**
	 * boolean to know whether the unit is inside something
	 */
	private boolean carried;

	/**
	 * the space the unit takes
	 */
	private int unitSlots;

	public WorkerInfantery(int health, int maxHealth, boolean selected, Faction factionName, String name,
			Coordinates position, Description description, int speed, int damagePerShot, float fireRate, int range,
			boolean carried, int unitSlots) {
		super(health, maxHealth, selected, factionName, name, position, description, speed, damagePerShot, fireRate,
				range);
		this.carried = carried;
		this.unitSlots = unitSlots;
	}

	public boolean isCarried() {
		return carried;
	}

	public void setCarried(boolean carried) {
		this.carried = carried;
	}

	public int getUnitSlots() {
		return unitSlots;
	}

	public void setUnitSlots(int unitSlots) {
		this.unitSlots = unitSlots;
	}

}
