package cli.data.unit;

import cli.data.Coordinates;
import cli.data.Description;
import cli.data.faction.Faction;

/**
 * Heavy terrestrial vehicle, basically tanks
 * 
 * @author Awen
 *
 */
public class HeavyTV extends TerrestrialVehicle {

	

	public HeavyTV(int maxHealth, int armorPoints, int armorType, Faction faction, String name, Coordinates position,
			Description description, int speed, int damagePerShot, int typeOfDammage, int timeBeetweenShots, int range,
			int positionState, int unitSlots) {
		super(maxHealth, armorPoints, armorType, faction, name, position, description, speed, damagePerShot, typeOfDammage,
				timeBeetweenShots, range, positionState, unitSlots);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return super.toString();
	}

}
