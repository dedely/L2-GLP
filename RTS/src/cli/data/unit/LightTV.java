package cli.data.unit;

import java.util.ArrayList;

import cli.data.Coordinates;
import cli.data.faction.Faction;

/**
 * Light terrestrial vehicle, something like armored car.
 * 
 * @author Awen
 *
 */
public class LightTV extends GroundUnit {

	/**
	 * how many soldiers can fit inside the vehicle
	 */
	private int infantrySeats;

	/**
	 * how many more soldiers can fit inside the vehicle
	 */
	private int infantrySeatsRemaining;

	/**
	 * the list of soldiers inside the vehicle if any
	 */
	private ArrayList<GroundUnit> infanteryIn = new ArrayList<GroundUnit>();

	public LightTV(String name, int cost, Faction faction, int maxHealth, int armorPoints, int armorType,
			String description, Coordinates position, int speed, int damagePerShot, int typeOfDammage,
			int timeBeetweenShots, int timeLeftToReload, int range, boolean canShootAtAirTarget,
			boolean hasSecondariesOrMounted, int unitSlots, int infantrySeats, int infantrySeatsRemaining,
			ArrayList<GroundUnit> infanteryIn) {
		super(name, cost, faction, maxHealth, armorPoints, armorType, description, position, speed, damagePerShot,
				typeOfDammage, timeBeetweenShots, timeLeftToReload, range, canShootAtAirTarget, hasSecondariesOrMounted,
				unitSlots);
		this.infantrySeats = infantrySeats;
		this.infantrySeatsRemaining = infantrySeatsRemaining;
		this.infanteryIn = infanteryIn;
	}

	/**
	 * @return how many soldiers can fit inside the vehicle
	 */
	public int getInfantrySeats() {
		return infantrySeats;
	}

	/**
	 * @param infantrySeats how many soldiers can fit inside the vehicle
	 */
	public void setInfantrySeats(int infantrySeats) {
		this.infantrySeats = infantrySeats;
	}

	/**
	 * @return the list of soldiers inside the vehicle if any
	 */
	public ArrayList<GroundUnit> getInfanteryIn() {
		return infanteryIn;
	}

	public ArrayList<GroundUnit> getUnitsIn() {
		return infanteryIn;
	}

	/**
	 * @param infanteryIn the list of soldiers inside the vehicle if any(preferably
	 *                    use getInfantery and modify the existing one)
	 */
	public void setInfanteryIn(ArrayList<GroundUnit> infanteryIn) {
		this.infanteryIn = infanteryIn;
	}

	/**
	 * @return the number of seats remaining
	 */
	public int getInfantrySeatsRemaining() {
		return infantrySeatsRemaining;
	}

	/**
	 * @param infantrySeatsRemaining the number of seats remaining for units to
	 *                               embark
	 */
	public void setInfantrySeatsRemaining(int infantrySeatsRemaining) {
		this.infantrySeatsRemaining = infantrySeatsRemaining;
	}

	@Override
	public String toString() {
		return super.toString() + "\ninfantrySeats = " + infantrySeats + "\ninfantrySeatsRemaining = "
				+ infantrySeatsRemaining;
	}

}
