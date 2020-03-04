package process.factory;

import data.Constants;
import data.faction.Faction;

public class FactionFactory {
	/*
	 * public static Faction createFaction(String side, String name) throws
	 * IllegalArgumentException { if(side == Constants.FEDERATION) return new
	 * Faction(side, name, null, null); if(side == Constants.UNION) return new
	 * Faction(side, name, null, null); if(side == Constants.REPUBLIC) return new
	 * Faction(side, name, null, null); throw new
	 * IllegalArgumentException("Faction"+side+" is not defined"); }
	 */

	public static Faction createFaction(String side, String name) throws IllegalArgumentException {
		if (side.equals(Constants.FEDERATION) || side.equals(Constants.REPUBLIC) || side.equals(Constants.UNION)) {
			return new Faction(side, name, null, null);
		} else {
			throw new IllegalArgumentException("Faction" + side + " is not defined");
		}
	}
}