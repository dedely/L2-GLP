package cli.data.unit;

public class Weapon {
	private int damagePerShot;

	/**
	 * Whether it is Light, SuperLight or heavy armor
	 * 
	 */
	private int TypeOfDammage;

	/**
	 * The number of ticks between shots
	 * 
	 */
	private int timeBeetweenShots;
	private int timeLeftToReload;

	/**
	 * The maximum distance between the unit and the target for it to shoot
	 * 
	 */
	private int range;

	/**
	 * The maximum distance between the unit and the target for it to shoot
	 * 
	 */
	private int minimuRange;

	/**
	 * Whether or not a weapon can shot air targets
	 */
	private boolean canShootAtAirTarget;

	public Weapon(int damagePerShot, int typeOfDammage, int timeBeetweenShots, int range,
			int minimuRange, boolean canShootAtAirTarget) {
		super();
		this.damagePerShot = damagePerShot;
		TypeOfDammage = typeOfDammage;
		this.timeBeetweenShots = timeBeetweenShots;
		timeLeftToReload = timeBeetweenShots;
		this.range = range;
		this.minimuRange = minimuRange;
		this.canShootAtAirTarget = canShootAtAirTarget;
	}

	public int getDamagePerShot() {
		return damagePerShot;
	}

	public void setDamagePerShot(int damagePerShot) {
		this.damagePerShot = damagePerShot;
	}

	public int getTypeOfDammage() {
		return TypeOfDammage;
	}

	public void setTypeOfDammage(int typeOfDammage) {
		TypeOfDammage = typeOfDammage;
	}

	public int getTimeBeetweenShots() {
		return timeBeetweenShots;
	}

	public void setTimeBeetweenShots(int timeBeetweenShots) {
		this.timeBeetweenShots = timeBeetweenShots;
	}

	public int getTimeLeftToReload() {
		return timeLeftToReload;
	}

	public void setTimeLeftToReload(int timeLeftToReload) {
		this.timeLeftToReload = timeLeftToReload;
	}

	public int getRange() {
		return range;
	}

	public void setRange(int range) {
		this.range = range;
	}

	public int getMinimuRange() {
		return minimuRange;
	}

	public void setMinimuRange(int minimuRange) {
		this.minimuRange = minimuRange;
	}

	public boolean isCanShootAtAirTarget() {
		return canShootAtAirTarget;
	}

	public void setCanShootAtAirTarget(boolean canShootAtAirTarget) {
		this.canShootAtAirTarget = canShootAtAirTarget;
	}

	@Override
	public String toString() {
		return "\ndamagePerShot = " + damagePerShot + "\nTypeOfDammage = " + TypeOfDammage + "\ntimeBeetweenShots = "
				+ timeBeetweenShots + "\ntimeLeftToReload = " + timeLeftToReload + "\nrange = " + range
				+ "\nminimum range" + minimuRange + "\ncanShootAtAirTarget = " + canShootAtAirTarget;
	}

}
