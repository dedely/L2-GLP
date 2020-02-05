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
public class LightTV extends TerrestrialVehicle {

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
	private ArrayList<Infantry> infanteryIn = new ArrayList<Infantry>();

	public LightTV(int health, int maxHealth, boolean selected, Faction factionName, String name, Coordinates position,
			Description description, int speed, int damagePerShot, float fireRate, int range, boolean carried,
			int unitSlots, int infantrySeats, int infantrySeatsRemaining, ArrayList<Infantry> infanteryIn) {
		super(health, maxHealth, selected, factionName, name, position, description, speed, damagePerShot, fireRate,
				range, carried, unitSlots);
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
	public ArrayList<Infantry> getInfanteryIn() {
		return infanteryIn;
	}

	/**
	 * @param infanteryIn the list of soldiers inside the vehicle if any(preferably
	 *                    use getInfantery and modify the existing one)
	 */
	public void setInfanteryIn(ArrayList<Infantry> infanteryIn) {
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

}
