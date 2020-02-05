package cli.data.building;

public abstract class DefenseBuilding {
	private int range;
	private int damage;
	private int fireRate;
	
	public DefenseBuilding(int range, int damage, int fireRate) {
		this.range = range;
		this.damage = damage;
		this.fireRate = fireRate;
	}

	public int getRange() {
		return range;
	}

	public void setRange(int range) {
		this.range = range;
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public int getFireRate() {
		return fireRate;
	}

	public void setFireRate(int fireRate) {
		this.fireRate = fireRate;
	}

	@Override
	public String toString() {
		return "DefenseBuilding [range=" + range + ", damage=" + damage + ", fireRate=" + fireRate + "]";
	}
	
}
