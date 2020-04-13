package data.unit;

import data.Coordinates;
import process.visitor.SelectableVisitor;

/**
 * Generic TerrestrialVehicle, (basically tanks) but with a machine-gun on top
 * 
 * @author Awen
 *
 */

public class GroundUnitWithMountedWeapon extends GroundUnit {

	/**
	 * the infantry serving mounted weapon if any
	 */
	private GroundUnit infanteryIn;

	private boolean mounted = false;

	private Weapon mountedWeapon;

	public GroundUnitWithMountedWeapon(String name, int cost, String playerName, int maxHealth, int armorPoints,
			int armorType, String description, Coordinates position, int speed, Weapon weapon, int unitSize,
			Weapon mountedWeapon) {
		super(name, cost, playerName, maxHealth, armorPoints, armorType, description, position, speed, weapon,
				unitSize);
		this.mountedWeapon = mountedWeapon;
	}

	/**
	 * @return the infantry serving the mounted weapon if any
	 */
	public GroundUnit getInfanteryIn() {
		return infanteryIn;
	}

	/**
	 * @param infanteryIn the infantry that uses the mounted weapon
	 */
	public void setInfanteryIn(GroundUnit infanteryIn) {
		this.infanteryIn = infanteryIn;
	}

	/**
	 * @return return true if the weapon is installed, false otherwise
	 */
	public boolean isMounted() {
		return mounted;
	}

	/**
	 * @param Mounted the truth value of the weapon installation
	 */
	public void setMounted(boolean Mounted) {
		this.mounted = Mounted;
	}

	public Weapon getMountedWeapon() {
		return mountedWeapon;
	}

	public void setMountedWeapon(Weapon mountedWeapon) {
		this.mountedWeapon = mountedWeapon;
	}

	@Override
	public <T> T accept(SelectableVisitor<T> visitor) {
		return visitor.visit(this);
	}

	@Override
	public String toString() {
		return super.toString() + "\ninfanteryIn=" + infanteryIn.toString() + "\nmounted = " + mounted
				+ "\n mountedWeapon = " + mountedWeapon.toString();
	}

}