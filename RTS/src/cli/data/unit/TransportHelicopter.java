package cli.data.unit;

import java.util.ArrayList;

import cli.data.Coordinates;
import cli.data.faction.Faction;

/**
 * Class for instantiating transport helis
 * 
 * @author Awen
 *
 */
public class TransportHelicopter extends Unit {

	/**
	 * the space left for units to embark
	 */
	private int unitSlotsAvailable;

	/**
	 * the total space for units to embark
	 */
	private int unitSlots;

	/**
	 * the units inside the vehicle
	 */
	private ArrayList<Unit> unitsIn = new ArrayList<Unit>();

	public TransportHelicopter( String name, Faction faction, int maxHealth, int armorPoints, int armorType, String description,
			Coordinates position, int speed, int damagePerShot, int typeOfDammage,
			int timeBeetweenShots,boolean canShootTargetsOnDifferentHeight, int range, int unitSlotsAvailable, int unitSlots) {
		super( name,  faction,  maxHealth,  armorPoints,  armorType,  description,
				 position,  speed,  damagePerShot,  typeOfDammage,
				 timeBeetweenShots, range, canShootTargetsOnDifferentHeight);
		this.unitSlotsAvailable = unitSlotsAvailable;
		this.unitSlots = unitSlots;
	}

	/**
	 * @return how much more space is in the vehicle
	 */
	public int getUnitSlotsAvailable() {
		return unitSlotsAvailable;
	}

	/**
	 * @param unitSlotsAvailable how much more space is left inside the vehicle
	 */
	public void setUnitSlotsAvailable(int unitSlotsAvailable) {
		this.unitSlotsAvailable = unitSlotsAvailable;
	}

	/**
	 * @return how much space there is inside the vehicle when empty
	 */
	public int getUnitSlots() {
		return unitSlots;
	}

	/**
	 * @param totalUnitSlots how much space there is inside the vehicle when empty
	 */
	public void setUnitSlots(int totalUnitSlots) {
		this.unitSlots = totalUnitSlots;
	}

	/**
	 * @return the list of units inside the vehicle
	 */
	public ArrayList<Unit> getUnitsIn() {
		return unitsIn;
	}

	/**
	 * @param unitsIn the list of units inside the vehicle
	 */
	public void setUnitsIn(ArrayList<Unit> unitsIn) {
		this.unitsIn = unitsIn;
	}

	@Override
	public String toString() {
		return super.toString() + "\nunitSlotsAvailable = " + unitSlotsAvailable + "\nUnitSlots = " + unitSlots;
	}

}
