package data.unit;

import data.Coordinates;

public class GroundUnitSuicide extends GroundUnit {
	private boolean diesOnDamageDealt = true;

	public GroundUnitSuicide(String name, String playerName, int maxHealth, int armorPoints, int armorType,
			String description, Coordinates position, int speed, Weapon weapon, int unitSize) {
		super(name, playerName, maxHealth, armorPoints, armorType, description, position, speed, weapon, unitSize);
		// TODO Auto-generated constructor stub
	}

	public boolean isDiesOnDamageDealt() {
		return diesOnDamageDealt;
	}

	public void setDiesOnDamageDealt(boolean diesOnDamageDealt) {
		this.diesOnDamageDealt = diesOnDamageDealt;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	

}
