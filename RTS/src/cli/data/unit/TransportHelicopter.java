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

<<<<<<< Upstream, based on branch 'master' of https://github.com/Azilisiev/L2-GLP
<<<<<<< Upstream, based on branch 'master' of https://github.com/Azilisiev/L2-GLP
	public TransportHelicopter(String name, Faction faction, int cost, int maxHealth, int armorPoints, int armorType,
			String description, Coordinates position, int speed, int damagePerShot, int typeOfDammage,
			int timeBeetweenShots, boolean canShootAtAirTarget, int range, int unitSlots) {
		super(name, faction, cost, maxHealth, armorPoints, armorType, description, position, speed, damagePerShot,
				typeOfDammage, timeBeetweenShots, range, canShootAtAirTarget);
		this.unitSlotsAvailable = unitSlots;
=======
	public TransportHelicopter( String name, Faction faction, int cost, int maxHealth, int armorPoints, int armorType, String description,
			Coordinates position, int speed, int damagePerShot, int typeOfDammage,
<<<<<<< Upstream, based on branch 'master' of https://github.com/JustAdel/L2-GLP
			int timeBeetweenShots,boolean canShootTargetsOnDifferentHeight, int range, int unitSlotsAvailable, int unitSlots) {
		super( name,  faction, cost,  maxHealth,  armorPoints,  armorType,  description,
=======
			int timeBeetweenShots,boolean canShootAtAirTarget, int range, int unitSlotsAvailable, int unitSlots) {
		super( name,  faction,  maxHealth,  armorPoints,  armorType,  description,
>>>>>>> 2c156d2 modified Units classes to be formated and added boolean hasMountedWeaponOrSecondary
				 position,  speed,  damagePerShot,  typeOfDammage,
				 timeBeetweenShots, range, canShootAtAirTarget);
=======
	public TransportHelicopter(String name, Faction faction, int cost, int maxHealth, int armorPoints, int armorType,
			String description, Coordinates position, int speed, int damagePerShot, int typeOfDammage,

			int timeBeetweenShots, boolean canShootAtAirTarget, int range, int unitSlotsAvailable, int unitSlots) {
		super(name, faction, cost, maxHealth, armorPoints, armorType, description, position, speed, damagePerShot,
				typeOfDammage, timeBeetweenShots, range, canShootAtAirTarget);
>>>>>>> dd5b45e added all cost to Units classes
		this.unitSlotsAvailable = unitSlotsAvailable;
>>>>>>> c5f50c5 modified Units classes to be formated and added boolean hasMountedWeaponOrSecondary
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
