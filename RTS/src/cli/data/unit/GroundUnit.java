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

	public GroundUnit(String name, Faction faction, int cost, int maxHealth, int armorPoints, int armorType, String description,
			Coordinates position, int speed, int damagePerShot, int typeOfDammage, int timeBeetweenShots, int range,
<<<<<<< Upstream, based on branch 'master' of https://github.com/Azilisiev/L2-GLP
			boolean canShootAtAirTarget, int unitSlots) {
		super(name, faction, maxHealth, armorPoints, armorType, description, position, speed, damagePerShot,
				typeOfDammage, timeBeetweenShots, range, canShootAtAirTarget);
=======
			boolean canShootTargetsOnDifferentHeight, int unitSlots) {
		super(name, faction, cost, maxHealth, armorPoints, armorType, description, position, speed, damagePerShot,
				typeOfDammage, timeBeetweenShots, range, canShootTargetsOnDifferentHeight);
>>>>>>> 263feca Changes to all Unit classes to match changes made in Selectable.
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
