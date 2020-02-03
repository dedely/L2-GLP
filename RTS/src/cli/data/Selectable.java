package cli.data;

public abstract class Selectable {
	private int health;
	private int maxHealth;
	private boolean selected;
	private String factionName;
	private String name;
	
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
				+ factionName + ", name=" + name + "]";
	} 
	
}
