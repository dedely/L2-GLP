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
	private int timeBeetweenShots;
	private int timeLeftToReload;
	private int damageType;

	public DefenseBuilding(int maxHealth, int armorPoints, int armorType, Faction faction, String name,
			Coordinates position, Description description, int range, int damage, int timeBeetweenShots,
			int damageType) {
		super(maxHealth, armorPoints, armorType, faction, name, position, description);
		this.range = range;
		this.damage = damage;
		this.timeBeetweenShots = timeBeetweenShots;
		this.damageType = damageType;
		timeLeftToReload = 0;
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