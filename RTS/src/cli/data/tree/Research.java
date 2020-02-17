package cli.data.tree;

public class Research {

	private String name;
	private boolean unlocked;
	private int cost;
	private Upgrade upgrade;

	public Research(String name, int cost, Upgrade upgrade) {
		this.name = name;
		unlocked = false;
		this.cost = cost;
		this.upgrade = upgrade;
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

	public Upgrade getUpgrade() {
		return upgrade;
	}

	public void setUpgrade(Upgrade upgrade) {
		this.upgrade = upgrade;
	}

	@Override
	public String toString() {
		return "Research [name=" + name + ", unlocked=" + unlocked + ", cost=" + cost + "]";
	}

}