package cli.data.building;

import cli.data.Coordinates;
import cli.data.Description;
import cli.data.faction.Faction;

/**
 * @author Adel
 *
 */
public class Barracks extends UnitFactory {

	public Barracks(int maxHealth, int armorPoints, int armorType, Faction faction, String name, Coordinates position,
			Description description) {
		super(maxHealth, armorPoints, armorType, faction, name, position, description);
	}

	@Override
	public String toString() {
		return "Barracks [toString()=" + super.toString() + "]";
	}

}
