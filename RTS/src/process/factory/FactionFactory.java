package process.factory;

import data.Constants;
import data.faction.Faction;

public class FactionFactory {

	public static Faction createFaction(String side, String name, int team) throws IllegalArgumentException {
		if (side.equals(Constants.FEDERATION) || side.equals(Constants.REPUBLIC) || side.equals(Constants.UNION)) {
			return new Faction(side, name, null, null, team);
		} else {
			throw new IllegalArgumentException("Faction" + side + " is not defined");
		}
	}
}