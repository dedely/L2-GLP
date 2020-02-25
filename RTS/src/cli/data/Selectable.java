package cli.data;

import java.util.ArrayList;

import cli.data.order.Order;

/**
 * @author Adel
 *
 */
public abstract class Selectable {

	private String name;
	private int cost;

	private String owner;

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

	public Selectable(String name, int cost, String owner, int maxHealth, int armorPoints, int armorType,
			String description, Coordinates position) {
		this.name = name;
		this.cost = cost;
		this.owner = owner;
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

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
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

	public ArrayList<Order> getOrders() {
		return orders;
	}

	public void setOrders(ArrayList<Order> orders) {
		this.orders = orders;
	}

	@Override
	public String toString() {
		return "name=" + name + "\ncost=" + cost + "\nowner=" + owner + "\nmaxHealth=" + maxHealth + "\ncurrentHealth="
				+ currentHealth + "\narmorPoints=" + armorPoints + "\narmorType=" + armorType + "\nselected=" + selected
				+ "\ndescription=" + description + "\nposition=" + position + "]";
	}

}