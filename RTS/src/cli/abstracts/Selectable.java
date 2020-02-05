package cli.abstracts;

import cli.data.Coordinates;
import cli.data.Description;

/**
 * @author Adel
 *
 */
public abstract class Selectable {
	private int health;
	private int maxHealth;
	private boolean selected;
	private String factionName;
	private String name;
	private Coordinates position;
	private Description description;

	public Selectable(int health, int maxHealth, boolean selected, String factionName, String name,
			Coordinates position, Description description) {
		this.health = health;
		this.maxHealth = maxHealth;
		this.selected = selected;
		this.factionName = factionName;
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

	public String getFactionName() {
		return factionName;
	}

	public void setFactionName(String factionName) {
		this.factionName = factionName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Selectable [health=" + health + ", maxHealth=" + maxHealth + ", selected=" + selected + ", factionName="
				+ factionName + ", name=" + name + ", position=" + position + ", description=" + description + "]";
	}

}
