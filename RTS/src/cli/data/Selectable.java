package cli.data;

import cli.data.faction.Faction;

/**
 * @author Adel
 *
 */
public abstract class Selectable {

	private String name;
	private Faction faction;

	private int maxHealth;
	private int currentHealth;

	private int armorPoints;
	private int armorType;

	private boolean selected;

	private String description;

	private Coordinates position;

	/**
	 * @param maxHealth
	 * @param factionName
	 * @param name
	 * @param position
	 * @param description
	 * 
	 *                    health and selected do not need to be specified.
	 */

	public Selectable(String name, Faction faction, int maxHealth, int armorPoints, int armorType, String description,
			Coordinates position) {
		this.name = name;
		this.faction = faction;
		this.maxHealth = maxHealth;

		// When a new Selectable is created, its currentHealth equals its maxHealth.
		currentHealth = maxHealth;

		this.armorPoints = armorPoints;
		this.armorType = armorType;

		// The Selectable isn't selectable by default.
		selected = false;

		this.description = description;
		this.position = position;
	}

	public String getName() {
		return name;
	}

	public Faction getFaction() {
		return faction;
	}

	public void setFaction(Faction faction) {
		this.faction = faction;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMaxHealth() {
		return maxHealth;
	}

	public void setMaxHealth(int maxHealth) {
		this.maxHealth = maxHealth;
	}

	public int getCurrentHealth() {
		return currentHealth;
	}

	public void setCurrentHealth(int currentHealth) {
		this.currentHealth = currentHealth;
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

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Coordinates getPosition() {
		return position;
	}

	public void setPosition(Coordinates position) {
		this.position = position;
	}

	@Override
	public String toString() {
		return "Selectable [name=" + name + ", faction=" + faction + ", maxHealth=" + maxHealth + ", currentHealth="
				+ currentHealth + ", armorPoints=" + armorPoints + ", armorType=" + armorType + ", selected=" + selected
				+ ", description=" + description + ", position=" + position + "]";
	}
}