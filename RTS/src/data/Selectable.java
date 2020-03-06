package data;

import java.util.ArrayList;

import data.faction.Faction;
import data.order.Order;
import process.visitor.SelectableVisitor;

/**
 * @author Adel
 *
 */
public abstract class Selectable {

	private String name;
	private int cost;

	private Faction faction;

	private int maxHealth;
	private int currentHealth;

	private int armorPoints;
	private int armorType;

	private boolean selected;

	private String description;

	private Coordinates position;

	private ArrayList<Order> orders = new ArrayList<Order>();

	/**
	 * @param maxHealth
	 * @param factionName
	 * @param name
	 * @param position
	 * @param description
	 * 
	 *                    health and selected do not need to be specified.
	 */

	public String getName() {
		return name;
	}

	public Selectable(String name, int cost, Faction faction, int maxHealth, int armorPoints, int armorType,
			String description, Coordinates position) {
		this.name = name;
		this.cost = cost;
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

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
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
	
	public int getPositionX() {
		return position.getAbsciss();
	}
	
	public int getPositionY() {
		return position.getOrdinate();
	}
	
	public int getPositionZ() {
		return position.getHeight();
	}

	public void setPosition(Coordinates position) {
		this.position = position;
	}

	public ArrayList<Order> getOrders() {
		return orders;
	}

	public void setOrders(ArrayList<Order> orders) {
		this.orders = orders;
	}
	
	public abstract <T> T accept(SelectableVisitor<T> visitor);

	@Override
	public String toString() {
		return "name=" + name + "\ncost=" + cost + "\nowner=" + faction + "\nmaxHealth=" + maxHealth + "\ncurrentHealth="
				+ currentHealth + "\narmorPoints=" + armorPoints + "\narmorType=" + armorType + "\nselected=" + selected
				+ "\ndescription=" + description + "\nposition=" + position + "]";
	}

}