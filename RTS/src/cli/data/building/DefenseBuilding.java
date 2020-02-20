package cli.data.building;

import cli.data.Coordinates;
import cli.data.Description;
import cli.data.faction.Faction;

/**
 * @author Adel
 *
 */
public class DefenseBuilding extends Building {

	private int range;
	private int damage;
	private int fireRate;

	public DefenseBuilding(int maxHealth, int armorPoints, int armorType, Faction faction, String name,
			Coordinates position, Description description) {
		super(maxHealth, armorPoints, armorType, faction, name, position, description);
	}

	public int getRange() {
		return range;
	}

	public void setRange(int range) {
		this.range = range;
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public int getFireRate() {
		return fireRate;
	}

	public void setFireRate(int fireRate) {
		this.fireRate = fireRate;
	}

	@Override
	public String toString() {
		return "DefenseBuilding [range=" + range + ", damage=" + damage + ", fireRate=" + fireRate + ", toString()="
				+ super.toString() + "]";
	}

}
