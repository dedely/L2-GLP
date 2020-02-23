package cli.data.unit;

import java.util.ArrayList;

import cli.data.Coordinates;
import cli.data.Description;
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

	public LightTV(int maxHealth, int armorPoints, int armorType, Faction faction, String name, Coordinates position,
			Description description, int speed, int damagePerShot, int typeOfDammage, int timeBeetweenShots, int range,
			int unitSlots, int infantrySeats, int infantrySeatsRemaining) {
		super(maxHealth, armorPoints, armorType, faction, name, position, description, speed, damagePerShot,
				typeOfDammage, timeBeetweenShots, range, unitSlots);
		this.infantrySeats = infantrySeats;
		this.infantrySeatsRemaining = infantrySeatsRemaining;
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
