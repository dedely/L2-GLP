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
	 * The minimal distance between the unit and the target for it to shoot
	 * 
	 */
	private int range;
	
	
	/**
	 * Whether or not a weapon can shot air targets
	 */
	private boolean canShootAtAirTarget;

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

	public boolean isCanShootAtAirTarget() {
		return canShootAtAirTarget;
	}

	public void setCanShootAtAirTarget(boolean canShootAtAirTarget) {
		this.canShootAtAirTarget = canShootAtAirTarget;
	}

	@Override
	public String toString() {
		return "Weapon :\ndamagePerShot = " + damagePerShot + "\nTypeOfDammage = " + TypeOfDammage + "\ntimeBeetweenShots = "
				+ timeBeetweenShots + "\ntimeLeftToReload = " + timeLeftToReload + "\nrange = " + range
				+ "\ncanShootAtAirTarget = " + canShootAtAirTarget;
	}
	
	

}
