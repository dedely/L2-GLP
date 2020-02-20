package cli.data;

import cli.data.faction.Faction;

/**
 * @author Adel
 *
 */
public abstract class Selectable {

	private int health;
	private int maxHealth;
	private int armorPoints;
	private int armorType;
	private boolean selected;
	private Faction faction;
	private String name;
	private Coordinates position;
	private Description description;

	/**
	 * @param maxHealth
	 * @param factionName
	 * @param name
	 * @param position
	 * @param description
	 * 
	 *                    health and selected do not need to be specified.
	 */
	public Selectable(int maxHealth, int armorPoints, int armorType, Faction faction, String name, Coordinates position,
			Description description) {
		health = maxHealth;
		this.maxHealth = maxHealth;
		this.armorPoints = armorPoints;
		this.armorType = armorType;
		selected = false;
		this.faction = faction;
		this.name = name;
		this.position = position;
		this.description = description;
	}

	public Coordinates getPosition() {
		return position;
	}

	public void setPosition(Coordinates position) {
		this.position = position;
	}

	public Description getDescription() {
		return description;
	}

	public void setDescription(Description description) {
		this.description = description;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public int getMaxHealth() {
		return maxHealth;
	}

	public void setMaxHealth(int maxHealth) {
		this.maxHealth = maxHealth;
	}

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}

	public void setFactionName(Faction factionName) {
		this.faction = factionName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;

	}

	public int getArmorPoints() {
		return armorPoints;
	}

	public void setArmorPoints(int armorPoints) {
		this.armorPoints = armorPoints;
	}

	public int getArmorType() {
		return armorType;
	}

	public void setArmorType(int armorType) {
		this.armorType = armorType;
	}

	public Faction getFaction() {
		return faction;
	}

	public void setFaction(Faction faction) {
		this.faction = faction;
	}

	@Override
	public String toString() {
		return name + " :" + "\nhealth = " + health + "\nmaxHealth = " + maxHealth + "\nselected = " + selected
				+ "\nfactionName = " + faction.getName() + "\nposition = " + position + "\ndescription = " + description;
	}

}
