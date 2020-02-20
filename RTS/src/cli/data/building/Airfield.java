package cli.data.building;

import cli.data.Coordinates;
import cli.data.Description;
import cli.data.faction.Faction;

/**
 * @author Adel
 *
 */
public class Airfield extends UnitFactory {

	public Airfield(int maxHealth, int armorPoints, int armorType, Faction faction, String name, Coordinates position,
			Description description) {
		super(maxHealth, armorPoints, armorType, faction, name, position, description);
	}

	@Override
	public String toString() {
		return "Airfield [toString()=" + super.toString() + "]";
	}

}
