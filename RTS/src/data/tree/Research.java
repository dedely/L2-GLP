package data.tree;

import java.util.ArrayList;

/**
 * @author Maria
 *
 */
public class Research {

	private Integer id;
	private String name;
	private boolean unlocked = false;
	private int cost;
	private ArrayList<Upgrade> upgrades = new ArrayList<Upgrade>();
	private int timeLeft;
	private int laboratoriesNumber;

	public Research(Integer id, String name, boolean unlocked, int cost, int timeLeft) {
		this.id = id;
		this.name = name;
		this.cost = cost;
		this.timeLeft = timeLeft;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getLaboratoriesNumber() {
		return laboratoriesNumber;
	}

	public void setLaboratoriesNumber(int laboratoriesNumber) {
		this.laboratoriesNumber = laboratoriesNumber;
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
	
	public void unlock() {
		setUnlocked(true);
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public int getTimeLeft() {
		return timeLeft;
	}

	public void setTimeLeft(int time) {
		timeLeft = time;
	}

	public ArrayList<Upgrade> getUpgrades() {
		return upgrades;
	}

	public void addUpgrade(Upgrade upgrade) {
		if(upgrade != null) {
			upgrades.add(upgrade);
		}
	}
	
	public void removeUpgrade(Upgrade upgrade) {
		if(upgrades.contains(upgrade)) {
			upgrades.remove(upgrade);
		}
	}

	@Override
	public String toString() {
		return "Research [id=" + id + ", name=" + name + ", unlocked=" + unlocked + ", cost=" + cost + ", upgrades="
				+ upgrades + ", timeLeft=" + timeLeft + ", laboratoriesNumber=" + laboratoriesNumber + "]";
	}

}