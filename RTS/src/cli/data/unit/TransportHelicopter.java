package cli.data.unit;

import java.util.ArrayList;

import cli.data.Coordinates;
import cli.data.Description;
import cli.data.faction.Faction;

/**
 * Class for instantiating transport helis
 * 
 * @author Awen
 *
 */
public class TransportHelicopter extends AerialVehicles {

	/**
	 * the space left for units to embark
	 */
	private int unitSlotsAvailable;

	/**
	 * the total space for units to embark
	 */
	private int UnitSlots;

	/**
	 * the units inside the vehicle
	 */
	private ArrayList<Unit> unitsIn = new ArrayList<Unit>();

	

	public TransportHelicopter(int maxHealth, Faction factionName, String name, Coordinates position,
			Description description, int speed, int damagePerShot, float fireRate, int range, int unitSlotsAvailable,
			int unitSlots, ArrayList<Unit> unitsIn) {
		super(maxHealth, factionName, name, position, description, speed, damagePerShot, fireRate, range);
		this.unitSlotsAvailable = unitSlotsAvailable;
		UnitSlots = unitSlots;
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
		return UnitSlots;
	}

	/**
	 * @param totalUnitSlots how much space there is inside the vehicle when empty
	 */
	public void setUnitSlots(int totalUnitSlots) {
		this.UnitSlots = totalUnitSlots;
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
		return "TransportHelicopter [unitSlotsAvailable=" + unitSlotsAvailable + ", UnitSlots=" + UnitSlots
				+ ", unitsIn=" + unitsIn + super.toString() + "]";
	}
	
	

}
