package data;

import java.util.ArrayList;
import java.util.LinkedList;

import data.order.Order;
import process.visitor.selectable.SelectableVisitor;

/**
 * @author Adel
 *
 */
public abstract class Selectable {

	private String name;
	private Integer id = null;

	private String playerName;

	private int maxHealth;
	private int currentHealth;

	private int armorPoints;
	private int armorType;

	private boolean selected;

	private String description;

	private Coordinates position;

	/**
	 * We use a FIFO approach to manage orders. Given that we only need to perform
	 * insertion and remove operations on orders, a {@link LinkedList} should
	 * provide better performance than an {@link ArrayList}.
	 * 
	 */
	private LinkedList<Order> ordersLL = new LinkedList<Order>();

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

	public Selectable(String name, String playerName, int maxHealth, int armorPoints, int armorType,
			String description, Coordinates position) {
		this.name = name;
		this.playerName = playerName;
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


	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @param order The order will be placed at the end of our queue, according to
	 *              the FIFO approach.
	 */
	public void addOrder(Order order) {
		ordersLL.add(order);
	}

	/**
	 * @return the next order (i.e. the first order in the list) and removes it from
	 *         the list.
	 */
	public Order getNextOrder() {
		Order order = null;
		if (ordersLL.size() > 0) {
			order = ordersLL.remove();
		}
		return order;
	}

	public abstract <T> T accept(SelectableVisitor<T> visitor);

	@Override
	public String toString() {
		return "Selectable [name=" + name + ", id=" + id + ", playerName=" + playerName
				+ ", maxHealth=" + maxHealth + ", currentHealth=" + currentHealth + ", armorPoints=" + armorPoints
				+ ", armorType=" + armorType + ", selected=" + selected + ", description=" + description + ", position="
				+ position + ", ordersLL=" + ordersLL + "]";
	}

}