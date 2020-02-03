package cli.data;

import java.util.ArrayList;

import cli.abstracts.AerialVehicles;
import cli.abstracts.Unit;

/** Class for instantiating transport helis
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

	public TransportHelicopter(int speed, int damagePerShot, float fireRate, int range, int unitSlotsAvailable,
			int UnitSlots) {
		super(speed, damagePerShot, fireRate, range);
		unitSlotsAvailable = UnitSlots;
		this.UnitSlots = UnitSlots;
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
	
	
	
	
	




	
	

}
