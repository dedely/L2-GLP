package cli.data.building;

import cli.data.Coordinates;
import cli.data.faction.Faction;

/**
 * @author Adel
 *
 */
public class DefenseBuilding extends Building {

	private int range;
	private int damage;
	private int timeBeetweenShots;
	private int timeLeftToReload;
	private int damageType;

	public DefenseBuilding(String name, int cost, Faction faction, int maxHealth, int armorPoints, int armorType,
			String description, Coordinates position, Size size, int range, int damage, int timeBeetweenShots,
			int timeLeftToReload, int damageType) {
		super(name, cost, faction, maxHealth, armorPoints, armorType, description, position, size);
		this.range = range;
		this.damage = damage;
		this.timeBeetweenShots = timeBeetweenShots;
		this.timeLeftToReload = timeLeftToReload;
		this.damageType = damageType;
	}

	public int getDamageType() {
		return damageType;
	}

	public void setDamageType(int damageType) {
		this.damageType = damageType;
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

	public int getTimeBeetweenShots() {
		return timeBeetweenShots;
	}

	public void setTimeBeetweenShots(int timeBeetweenShots) {
		this.timeBeetweenShots = timeBeetweenShots;
	}

	public int getTimeLeftToReload() {
		return timeLeftToReload;
	}

	public void setTimeLeftToReload(int timeLeftToReload) {
		this.timeLeftToReload = timeLeftToReload;
	}

	@Override
	public String toString() {
		return "DefenseBuilding [range=" + range + ", damage=" + damage + ", timeBeetweenShots=" + timeBeetweenShots
				+ ", timeLeftToReload=" + timeLeftToReload + ", damageType=" + damageType + ", toString()="
				+ super.toString() + "]";
	}

}