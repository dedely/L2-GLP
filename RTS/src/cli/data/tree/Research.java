package cli.data.tree;

import java.util.ArrayList;

public class Research {

	private String name;
	private boolean unlocked;
	private int cost;
	private ArrayList <Upgrade> upgrades = new ArrayList<Upgrade>();

	public Research(String name, int cost, Upgrade upgrade) {
		super();
		this.name = name;
		unlocked = false;
		this.cost = cost;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isUnlocked() {
		return unlocked;
	}

	public void setUnlocked(boolean unlocked) {
		this.unlocked = unlocked;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public ArrayList<Upgrade> getUpgrades() {
		return upgrades;
	}

	@Override
	public String toString() {
		return "Research [name=" + name + ", unlocked=" + unlocked + ", cost=" + cost + "]";
	}

}