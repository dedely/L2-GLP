package cli.data.unit;

import cli.data.Coordinates;
import cli.data.Description;
import cli.data.faction.Faction;

/**
 * Abstract class representing the foot soldiers of various types.
 * 
 * @author Awen
 *
 */
public abstract class Infantry extends Unit {

	/**
	 * the space the unit takes
	 */
	private int unitSlots;


	public Infantry(int maxHealth, int armorPoints, int armorType, Faction faction, String name, Coordinates position,
			Description description, int speed, int damagePerShot, int timeBeetweenShots, int range, int positionState,
			int unitSlots) {
		super(maxHealth, armorPoints, armorType, faction, name, position, description, speed, damagePerShot,
				timeBeetweenShots, range, positionState);
		this.unitSlots = unitSlots;
	}

	/**
	 * the space the infantry unit takes when inside something
	 */
	public int getUnitSlots() {
		return unitSlots;
	}

	/**
	 * @param unitSlots how much space the infantry unit takes
	 */
	public void setUnitSlots(int unitSlots) {
		this.unitSlots = unitSlots;
	}

	@Override
	public String toString() {
		return "Infantry [ unitSlots=" + unitSlots + super.toString() + "]";
	}

}
