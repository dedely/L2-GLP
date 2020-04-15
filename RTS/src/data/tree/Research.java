package data.tree;

import java.util.ArrayList;


public class Research {

	private String name;
	private boolean unlocked;
	private int cost;
	private ArrayList <Upgrade> upgrades = new ArrayList<Upgrade>();
	private int timeLeft;
	private int laboratoriesNumber;

	public Research(String name, int cost, Upgrade upgrade, int timeLeft) {
		super();
		this.name = name;
		unlocked = false;
		this.cost = cost;
		this.timeLeft = timeLeft;
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

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public int getTimeLeft() {
		return timeLeft;
	}
	
	public void setTimeLeft(int time){
		timeLeft = time;
	}

	public void addUpgrade (Upgrade upgrade) {
		upgrades.add(upgrade);
	}

	public ArrayList<Upgrade> getUpgrades() {
		return upgrades;
	}
	
	public void setUpgrades (ArrayList<Upgrade> upgrades) {
		this.upgrades = upgrades;
	}

	@Override
	public String toString() {
		return "Research \n[name = " + name + "\nunlocked = " + unlocked + "\ncost = " + cost + "\ntimeLeft = "+ timeLeft + "\nupgrades = " + upgrades.toString() + " ]";
	}

}