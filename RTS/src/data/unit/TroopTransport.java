package data.unit;

import java.util.ArrayList;

import data.Coordinates;
import process.visitor.selectable.SelectableVisitor;

/**
 * Light terrestrial vehicle, something like armored car.
 * 
 * @author Awen
 *
 */
public class TroopTransport extends GroundUnit {

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

	public TroopTransport(String name, String playerName, int maxHealth, int armorPoints, int armorType,
			String description, Coordinates position, int speed, Weapon weapon, int unitSize, int infantrySeats) {
		super(name, playerName, maxHealth, armorPoints, armorType, description, position, speed, weapon,
				unitSize);
		this.infantrySeats = infantrySeats;
		infantrySeatsRemaining = infantrySeats;
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
	public <T> T accept(SelectableVisitor<T> visitor) {
		return visitor.visit(this);
	}

	@Override
	public String toString() {
		return super.toString() + "\ninfantrySeats = " + infantrySeats + "\ninfantrySeatsRemaining = "
				+ infantrySeatsRemaining + "\nInfantryIn = " + infanteryIn.toString();
	}

}
