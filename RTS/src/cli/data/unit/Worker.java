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



	public Worker(int maxHealth, Faction faction, String name, Coordinates position, Description description, int speed,
			int damagePerShot, int timeBeetweenShots, int range, int positionState, int unitSlots) {
		super(maxHealth, faction, name, position, description, speed, damagePerShot, timeBeetweenShots, range,
				positionState);
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
